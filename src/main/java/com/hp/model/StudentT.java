package com.hp.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class StudentT {
	 
	 	@Id
	 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long mStudentId; 
	    private String studentName;
	    private String dateOfBirth;

	   
	    
	    @ManyToMany(cascade = CascadeType.PERSIST)
	    @JoinTable(
	    name = "student_class", joinColumns = @JoinColumn(name = "Student_Id", referencedColumnName = "mStudentId"),
	    inverseJoinColumns = @JoinColumn(name = "Class_Id", referencedColumnName = "mClassId"))
	    
	    @JsonIgnore   
	 private Set<ClassT> classes = new HashSet<>();
    public StudentT() { }


	public StudentT(Long mStudentId, String studentName, String dateOfBirth, Set<ClassT> classes) {
		super();
		this.mStudentId = mStudentId;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.classes = classes;
	}


	public Long getStudentId() {
		return mStudentId;
	}


	public void setStudentId(Long mStudentId) {
		this.mStudentId = mStudentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Set<ClassT> getClasses() {
		return classes;
	}


	public void setClasses(Set<ClassT> classes) {
		this.classes = classes;
	}
    
    
}