package com.yashjain.springdatajpatutorial.respository;

import com.yashjain.springdatajpatutorial.entities.Course;
import com.yashjain.springdatajpatutorial.entities.CourseMaterial;
import com.yashjain.springdatajpatutorial.entities.Student;
import com.yashjain.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCoursesWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Sharma")
                .build();

        Course course = Course.builder()
                .title("Python course")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println(courses + " " + totalElements + " " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(1, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").and(Sort.by("credit").descending()));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 20);

        List<Course> courses = courseRepository.findByTitleContaining("P", firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizy")
                .lastName("Sharma")
                .build();

        Student student = Student.builder()
                .emailId("taru@gmail.com")
                .firstName("taru")
                .lastName("singh")
                .build();

        Course course = Course
                .builder()
                .title("AI Course")
                .credit(12)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllCourseWithTeachersAndStudent() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }
}