package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Grade;
import static org.assertj.core.api.Assertions.assertThat;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;
import fr.uga.im2ag.l3.miage.db.model.Person.Gender;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherTest extends Base {

    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        teacherRepository = daoFactory.newTeacherRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveTeacher()  {
        // TODO
    	Subject subject = Fixtures.createSubject();
    	
    	subject.setName("Histoire");
    	
    	GraduationClass gClass = new GraduationClass();
    	
    	gClass.setName("GEO");
    	gClass.setYear(2015);
    	gClass.setStudents(null);
    	
    	var grade_a = Fixtures.createGrade(subject);
    	grade_a.setValue(10.0f);
    	grade_a.setWeight(1.5f);
    	
    	var grade_b = Fixtures.createGrade(subject);
    	grade_b.setValue(12.0f);
    	grade_b.setWeight(1.5f);
    	
   

    	Teacher teacher = Fixtures.createTeacher(subject, gClass,null);
    	
    	  entityManager.getTransaction().begin();
    	  entityManager.persist(subject);
    	  entityManager.persist(gClass);
    	  entityManager.persist(grade_a);
    	  entityManager.persist(grade_b);
    	  entityManager.persist(teacher);
    	  entityManager.getTransaction().commit();
    	  entityManager.detach(subject);
    	  entityManager.detach(gClass);
    	  entityManager.detach(grade_a);
    	  entityManager.detach(grade_b);
    	  entityManager.detach(teacher);
    	  
    	  var aTeacher = teacherRepository.findById(teacher.getId());
    	  assertThat(aTeacher.getId()==1);
    	  assertThat(aTeacher.getHeading().getName()=="GEO");
    	  assertThat(aTeacher.getTeaching().getName()=="Histoire");
    	
    }

    @Test
    void shouldFindHeadingGraduationClassByYearAndName() {
        // TODO
Subject subject = Fixtures.createSubject();
    	
    	subject.setName("Histoire");
    	
    	GraduationClass gClass = new GraduationClass();
    	
    	gClass.setName("GEO");
    	gClass.setYear(2015);
    	gClass.setStudents(null);
    	
    	var grade_a = Fixtures.createGrade(subject);
    	grade_a.setValue(10.0f);
    	grade_a.setWeight(1.5f);
    	
    	var grade_b = Fixtures.createGrade(subject);
    	grade_b.setValue(12.0f);
    	grade_b.setWeight(1.5f);
    	
   

    	Teacher teacher = Fixtures.createTeacher(subject, gClass,null);
    	teacher.setFirstName("Walter");
    	
     entityManager.getTransaction().begin();
   	  entityManager.persist(subject);
   	  entityManager.persist(gClass);
   	  entityManager.persist(grade_a);
   	  entityManager.persist(grade_b);
   	  entityManager.persist(teacher);
   	  entityManager.getTransaction().commit();
   	  entityManager.detach(subject);
   	  entityManager.detach(gClass);
   	  entityManager.detach(grade_a);
   	  entityManager.detach(grade_b);
   	  entityManager.detach(teacher);
   	  
   	 assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2015, "GEO").getFirstName() =="Walter");
   	assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2015, "GEO").getHeading().getName() =="Histoire");
   	assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2015, "GEO").getHeading().getYear() == 2015);

    }

}
