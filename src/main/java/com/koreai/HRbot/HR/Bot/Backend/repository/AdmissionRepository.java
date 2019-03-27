package com.koreai.HRbot.HR.Bot.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreai.HRbot.HR.Bot.Backend.entity.Admission;
import com.koreai.HRbot.HR.Bot.Backend.entity.Student;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {

	Admission findByStudent(Student student);

}
