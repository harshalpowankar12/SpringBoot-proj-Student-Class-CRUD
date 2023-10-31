package com.hp.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ClassT {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long  mClassId; 
    private String className;
    private Integer creditHours;

    @ManyToMany(mappedBy = "classes",fetch = FetchType.LAZY)
    
    private Set<StudentT> students = new HashSet<>();

   public ClassT()
   {
	   
   }

public ClassT(Long mClassId, String className, Integer creditHours, Set<StudentT> students) {
	super();
	this.mClassId = mClassId;
	this.className = className;
	this.creditHours = creditHours;
	this.students = students;
}

public Long getClassId() {
	return mClassId;
}

public void setClassId(Long mClassId) {
	this.mClassId = mClassId;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public Integer getCreditHours() {
	return creditHours;
}

public void setCreditHours(Integer creditHours) {
	this.creditHours = creditHours;
}

public Set<StudentT> getStudents() {
	return students;
}

public void setStudents(Set<StudentT> students) {
	this.students = students;
}
   
  
   
   
}