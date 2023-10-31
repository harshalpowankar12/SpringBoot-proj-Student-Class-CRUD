package com.hp.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hp.model.ClassT;
import com.hp.model.StudentT;
import com.hp.repo.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentT> getAllStudents() {
        return studentRepository.findAll();
    }
    public StudentT getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }
    public StudentT createStudent(StudentT student) {
        return studentRepository.save(student);
    }
    public StudentT updateStudent(Long studentId, StudentT updatedStudent) {
    	StudentT existingStudent = getStudentById(studentId);
        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
        return studentRepository.save(existingStudent);
    }
    public void deleteStudent(Long studentId) {
    	StudentT student = getStudentById(studentId);
        studentRepository.delete(student);
    }
    public Set<ClassT> getClassesForStudent(Long studentId) {
    	StudentT student = getStudentById(studentId);
        return student.getClasses();
    }
    
    public List<StudentT> getAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "dateOfBirth");
        return studentRepository.findAll(sort);
    }
}
