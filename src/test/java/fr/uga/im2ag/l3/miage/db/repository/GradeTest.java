package fr.uga.im2ag.l3.miage.db.repository;
import java.sql.Date;

import java.time.LocalDate;
import fr.uga.im2ag.l3.miage.db.repository.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GradeTest extends Base {

    GradeRepository gradeRepository;

    @BeforeEach
    void before() {
        gradeRepository = daoFactory.newGradeRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveGrade() {
        // TODO
    
    	
    	Subject subject = Fixtures.createSubject();
    	//subject.setId((long)1);
     	subject.setName("Math");
     	subject.setHours((float) 5.0);
     	 // Create a date object
     	@SuppressWarnings("deprecation")
     	
		Date d = new Date(2022,2,28);
     	@SuppressWarnings("deprecation")
     	Date e = new Date(2022,3,1);
     	
     	subject.setStart(d);
     	subject.setPoints(5);
     	subject.setEnd(e);
     	
    	 final var grade = Fixtures.createGrade(subject) ;
    	 
    	
    	 
    	
    	 entityManager.getTransaction().begin();
    	  entityManager.persist(subject); 
    	 gradeRepository.save(grade);
    	 entityManager.getTransaction().commit();
    	 entityManager.detach(subject);
    	 entityManager.detach(grade);
    	 
    	 var pGrade = gradeRepository.findById(grade.getId());
    	 assertThat(pGrade).isNotNull().isNotSameAs(grade);
         assertThat(pGrade.getValue()).isEqualTo(grade.getValue());
         assertThat(pGrade.getWeight()).isEqualTo(grade.getWeight());
    }

    @Test
    void shouldFailUpgradeGrade() {
        // TODO, ici tester que la mise à jour n'a pas eu lieu.
    	
    	final var subject = Fixtures.createSubject();
        final var grade = Fixtures.createGrade(subject);

        float oldGrade = grade.getValue();
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        gradeRepository.save(grade);
        gradeRepository.findById(grade.getId()).setValue(2000f); // updating value after saved
        entityManager.getTransaction().commit();
        entityManager.detach(grade);

        
        var result2 = gradeRepository.findById(grade.getId());
        
        assertThat(result2.getValue()).isEqualTo(oldGrade);
        assertThat(result2.getValue()).isNotEqualTo(2000f);
    }

    @Test
    void shouldFindHighestGrades() {
        // TODO
    	final var subject = Fixtures.createSubject();
        final var grade1 = Fixtures.createGrade(subject);
        final var grade2 = Fixtures.createGrade(subject);
        final var grade3 = Fixtures.createGrade(subject);

        entityManager.getTransaction().begin();
        entityManager.persist(subject); // need to persist the subject to avoid error
        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
        gradeRepository.save(grade3);
        entityManager.getTransaction().commit();
        
        grade1.setValue((float) 10.5);
        grade2.setValue((float) 12.5);
        grade3.setValue((float) 19.5);

        var result = gradeRepository.findHighestGrades(1);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getValue()).isEqualTo(grade3.getValue());
    }

    @Test
    void shouldFindHighestGradesBySubject() {
        // TODO
    	final var subject = Fixtures.createSubject();
   	 //subject.setId((long)1);
    	subject.setName("Physics");
    	subject.setHours((float) 5.0);
    	 // Create a date object
    	Date d = new Date(2022,2,28);
    	subject.setStart(d);
    	subject.setPoints(5);
    	subject.setEnd(d);
    	entityManager.getTransaction().begin();
    	entityManager.persist(subject);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(subject);
   	 	
    	gradeRepository.findHighestGradesBySubject(5, subject);
    	
    	final var subject_2 = Fixtures.createSubject();
      	 //subject.setId((long)1);
       	subject.setName("GEO");
       	subject.setHours((float) 2.0);
       	 // Create a date object
       	Date data = new Date(2022,2,28);
       	subject.setStart(data);
       	subject.setPoints(5);
       	subject.setEnd(data);
       	
       	gradeRepository.findHighestGradesBySubject(5, subject_2);
       	
    }

}
