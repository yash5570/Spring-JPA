package com.yashjain.springdatajpatutorial.respository;

import com.yashjain.springdatajpatutorial.entities.Guardian;
import com.yashjain.springdatajpatutorial.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("umeshjain@gmail.com")
                .firstName("umesh")
                .lastName("jain")
//                .guardianName("Anuj")
//                .guardianEmail("anuj@gmail.com")
//                .guardianMobile("4232321232")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("Akash@gmail.com")
                .name("Akash")
                .mobile("343431423434")
                .build();

        Student student = Student.builder()
                .emailId("Hitesh@gmail.com")
                .firstName("sangeeta")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("sangeeta");
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("um");
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("santhosh");
        System.out.println(students);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentWithLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("sangeeta@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("sangeeta@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentFirstNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("manisha", "yashjain@gmail.com");
    }
}