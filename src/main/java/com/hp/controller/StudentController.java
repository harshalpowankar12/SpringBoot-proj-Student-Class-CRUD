package com.hp.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.model.ClassT;
import com.hp.model.StudentT;
import com.hp.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentT> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{studentId}")
    public StudentT getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }
    @PostMapping
    public StudentT createStudent(@RequestBody StudentT student) {
        return studentService.createStudent(student);
    }
    @PutMapping("/{studentId}")
    public StudentT updateStudent(@PathVariable Long studentId, @RequestBody StudentT updatedStudent) {
        return studentService.updateStudent(studentId, updatedStudent);
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
    @GetMapping("/{studentId}/classes")
    public Set<ClassT> getClassesForStudent(@PathVariable Long studentId) {
        return studentService.getClassesForStudent(studentId);
    }
    @GetMapping("/sorted")
    public List<StudentT> getAllSortedByDate() {
        return studentService.getAllSortedByDate();
    }
}
