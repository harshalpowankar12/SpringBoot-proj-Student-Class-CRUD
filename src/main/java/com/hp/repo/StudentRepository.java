package com.hp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.model.StudentT;

public interface StudentRepository extends JpaRepository<StudentT, Long>{

}
