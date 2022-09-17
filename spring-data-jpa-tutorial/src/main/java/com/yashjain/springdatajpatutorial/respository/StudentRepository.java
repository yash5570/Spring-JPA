package com.yashjain.springdatajpatutorial.respository;

import com.yashjain.springdatajpatutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL Queries.
    @Query("select s from Student s where s.emailId = :emailId")
    public Student getStudentByEmailAddress(String emailId);

    //JPQL Queries.
    @Query("select s.firstName from Student s where s.emailId = :emailId")
    public String getStudentFirstNameByEmailAddress(String emailId);

    //Native Queries.
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM tbl_student s where s.email_address = ?1"
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param Queries.
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId"
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //Method to update the record of the student table.
    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value = "UPDATE tbl_student set first_name = ?1 where email_address = ?2"
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);
}
