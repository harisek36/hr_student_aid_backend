package com.koreai.HRbot.HR.Bot.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreai.HRbot.HR.Bot.Backend.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
