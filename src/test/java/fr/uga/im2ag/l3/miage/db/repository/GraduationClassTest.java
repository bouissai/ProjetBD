package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Person.Gender;
import fr.uga.im2ag.l3.miage.db.repository.api.GraduationClassRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraduationClassTest extends Base {

    GraduationClassRepository classRepository;

    @BeforeEach
    void before() {
        classRepository = daoFactory.newGraduationClassRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveClass() {
        // TODO
   	final var gClass = Fixtures.createClass() ; 
   	
   	
    	entityManager.getTransaction().begin();
    	classRepository.save(gClass);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(gClass);
   	 	
   	 	var check_graduation = classRepository.findById(gClass.getId());
   	 assertThat(check_graduation).isNotNull().isNotSameAs(gClass);
   	assertThat(check_graduation.getName()).isEqualTo(gClass.getName());
    assertThat(check_graduation.getYear()).isEqualTo(gClass.getYear());
    }


    @Test
    void shouldFindByYearAndName() {
    	//TEST 1
    	
    	GraduationClass gClass = new GraduationClass();
    	
    	gClass.setName("GEO");
    	gClass.setYear(2015);
    	gClass.setStudents(null);
    	
    	//TEST 2
    	GraduationClass gClass_G = Fixtures.createClass();
    	gClass_G.setName("Math");
    
    	gClass_G.setYear(2012);
    	gClass_G.setStudents(null);
    	//TEST 3
    	
    	GraduationClass gClass_P = Fixtures.createClass();
    	
    	gClass_P.setName("Phisique");
    	gClass_P.setYear(2017);
    	gClass_P.setStudents(null);
    	
    	entityManager.getTransaction().begin();
    	classRepository.save(gClass);
    	classRepository.save(gClass_G);
    	classRepository.save(gClass_P);
    	
    	entityManager.getTransaction().commit();
    	entityManager.detach(gClass);
    	entityManager.detach(gClass_G);
    	entityManager.detach(gClass_P);

    	List<GraduationClass> G = classRepository.getAll();
    	for ( GraduationClass g : G) {
    		System.out.println(g.getName());
    		System.out.println(g.getYear());
    	}
   	 
    	assertThat( classRepository.findByYearAndName(2012, "Math").getYear()==2012 && classRepository.findByYearAndName(2012, "Math").getName()=="Math");
    	assertThat( classRepository.findByYearAndName(2015, "GEO").getYear()==2015 && classRepository.findByYearAndName(2015, "GEO").getName()=="GEO");
    	assertThat( classRepository.findByYearAndName(2017, "Phisique").getYear()==2015 && classRepository.findByYearAndName(2015, "Phisique").getName()=="Phisique");

      
    }

}
