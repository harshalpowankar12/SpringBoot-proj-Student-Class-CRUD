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
import com.hp.service.ClassService;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassT> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{classId}")
    public ClassT getClassById(@PathVariable Long classId) {
        return classService.getClassById(classId);
    }

    @PostMapping
    public ClassT createClass(@RequestBody ClassT classT) {
        return classService.createClass(classT);
    }

    @PutMapping("/{classId}")
    public ClassT updateClass(@PathVariable Long classId, @RequestBody ClassT updatedClass) {
        return classService.updateClass(classId, updatedClass);
    }

    @DeleteMapping("/{classId}")
    public void deleteClass(@PathVariable Long classId) {
        classService.deleteClass(classId);
    }

    @GetMapping("/{classId}/students")
    public Set<StudentT> getStudentsInClass(@PathVariable Long classId) {
        return classService.getStudentsInClass(classId);
    }
}
