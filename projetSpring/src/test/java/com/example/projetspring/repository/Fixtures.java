package com.example.projetspring.repository;


import java.util.Random;

//Classe qui genere les données fictives pour les chaque instance de classe
public class Fixtures {
    /*
    public static Subject createSubject() {
        return new Subject()
                .setName(FAKER.funnyName().name())
                .setHours((float) FAKER.number().randomDouble(1, 10, 20))
                .setStart(FAKER.date().past(20, TimeUnit.DAYS))
                .setEnd(FAKER.date().future(20, TimeUnit.DAYS))
                .setPoints((int) FAKER.number().randomNumber(2, true));
    }


    public static Station createGrade(Station subject) {
        return new Station()
                .setSubject(subject)
                .setValue((float) FAKER.number().randomDouble(1, 0, 20))
                .setWeight((float) FAKER.number().randomDouble(1, 0, 10));
    }

    public static GraduationClass createClass() {
        return new GraduationClass()
                .setName(FAKER.zelda().character())
                .setYear(2021);
    }

    public static Station createStudent(GraduationClass graduationClass) {
        var student = new Student().setBelongTo(graduationClass);
        student.setBirth(FAKER.date().past(19 * 365, TimeUnit.DAYS))
                .setFirstName(FAKER.name().firstName())
                .setLastName(FAKER.name().lastName())
                .setGender(Person.Gender.values()[FAKER.number().numberBetween(0, 2)]);

        graduationClass.addStudent(student);

        return student;
    }

    public static Teacher createTeacher(Subject teaching, GraduationClass heading, Student... favs) {
        final var teacher = new Teacher()
                .setTeaching(teaching)
                .setHeading(heading);
        if (favs != null)
            teacher.setFavorites(Arrays.asList(favs));

        teacher.setBirth(FAKER.date().past(60 * 365, 30 * 365, TimeUnit.DAYS))
                .setFirstName(FAKER.name().firstName())
                .setLastName(FAKER.name().lastName())
                .setGender(Person.Gender.values()[FAKER.number().numberBetween(0, 2)]);

        return teacher;

    }*/

}
