package com.yashjain.springdatajpatutorial.respository;

import com.yashjain.springdatajpatutorial.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
