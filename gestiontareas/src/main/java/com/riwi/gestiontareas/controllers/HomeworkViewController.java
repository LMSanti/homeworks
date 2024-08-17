package com.riwi.gestiontareas.controllers;

import com.riwi.gestiontareas.entities.HomeworkEntity;
import com.riwi.gestiontareas.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class HomeworkViewController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/homework/list")
    public String viewHomeworkList(Model model) {
        List<HomeworkEntity> homeworks = homeworkService.getAllHomework();
        model.addAttribute("homeworks", homeworks);
        return "homework_list";
    }

    @GetMapping("/homework/{id}/view")
    public String viewHomeworkDetails(@PathVariable Long id, Model model) {
        HomeworkEntity homework = homeworkService.getHomeworkById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada: " + id));
        model.addAttribute("homework", homework);
        return "homework_details";
    }

    @GetMapping("/homework/new")
    public String showCreateForm(Model model) {
        HomeworkEntity homework = new HomeworkEntity();
        model.addAttribute("homework", homework);
        return "homework_form";
    }


    @GetMapping("/homework/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        HomeworkEntity homework = homeworkService.getHomeworkById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada: " + id));
        model.addAttribute("homework", homework);
        return "homework_form";
    }

    @PostMapping("/homework/save")
    public String saveHomework(@ModelAttribute("homework") HomeworkEntity homework) {
        if (homework.getId() == null) {
            homework.setDateCreation(LocalDate.now());
            homework.setTimeCreation(LocalTime.now());
        }
        homeworkService.saveHomework(homework);
        return "redirect:/homework/list";
    }

    @GetMapping("/homework/{id}/delete")
    public String deleteHomework(@PathVariable Long id) {
        homeworkService.deleteHomework(id);
        return "redirect:/homework/list";


    }
}
