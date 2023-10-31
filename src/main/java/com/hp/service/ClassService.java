package com.hp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.model.ClassT;
import com.hp.model.StudentT;
import com.hp.repo.ClassRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassT> getAllClasses() {
        return classRepository.findAll();
    }

    public ClassT getClassById(Long classId) {
        return classRepository.findById(classId)
                .orElseThrow(() -> new EntityNotFoundException("Class not found"));
    }

    public ClassT createClass(ClassT classT) {
        return classRepository.save(classT);
    }

    public ClassT updateClass(Long classId, ClassT updatedClass) {
    	ClassT existingClass = getClassById(classId);
        existingClass.setClassName(updatedClass.getClassName());
        existingClass.setCreditHours(updatedClass.getCreditHours());
        return classRepository.save(existingClass);
    }

    public void deleteClass(Long classId) {
    	ClassT classT = getClassById(classId);
        classRepository.delete(classT);
    }

    public Set<StudentT> getStudentsInClass(Long classId) {
        ClassT classT = getClassById(classId);
        return classT.getStudents();
    }
}
