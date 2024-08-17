package com.riwi.gestiontareas.controllers;

import com.riwi.gestiontareas.entities.HomeworkEntity;
import com.riwi.gestiontareas.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping
    public List<HomeworkEntity> getAllHomeworks(){
        return homeworkService.getAllHomework();
    }

    @GetMapping("/{id}")
    public Optional<HomeworkEntity> getHomeworkById(@PathVariable Long id){
        return homeworkService.getHomeworkById(id);
    }

    @PostMapping
    public HomeworkEntity createHomework(@RequestBody HomeworkEntity homework){
        return homeworkService.saveHomework(homework);
    }

    @PostMapping("/{id}")
    public HomeworkEntity updateHomework(@PathVariable Long id, @RequestBody HomeworkEntity homework){
        homework.setId(id);
        return homeworkService.saveHomework(homework);
    }

    @DeleteMapping("/{id}")
    public String deleteHomework(@PathVariable Long id){
        homeworkService.deleteHomework(id);
        return "Homework eliminated sucesfull";
    }
}
