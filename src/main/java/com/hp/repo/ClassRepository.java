package com.hp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.model.ClassT;

public interface ClassRepository extends JpaRepository<ClassT, Long>{

}
