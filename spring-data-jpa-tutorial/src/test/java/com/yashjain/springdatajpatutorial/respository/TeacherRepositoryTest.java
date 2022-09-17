package com.yashjain.springdatajpatutorial.respository;

import com.yashjain.springdatajpatutorial.entities.Course;
import com.yashjain.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

//    @Test
//    public void saveTeacher() {
//        Course courseReact = Course.builder()
//                .title("React Course")
//                .credit(3)
//                .build();
//
//        Course courseDatabase = Course.builder()
//                .title("Database Course")
//                .credit(4)
//                .build();
//
//
//        Teacher teacher = Teacher.builder()
//                .firstName("Shanti")
//                .lastName("Kumar")
//                .courses(List.of(courseReact, courseDatabase))
//                .build();
//
//        teacherRepository.save(teacher);
//    }
}