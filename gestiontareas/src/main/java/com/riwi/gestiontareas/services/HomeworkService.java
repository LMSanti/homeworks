package com.riwi.gestiontareas.services;

import com.riwi.gestiontareas.entities.HomeworkEntity;
import com.riwi.gestiontareas.repositories.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepositoy;

    public List<HomeworkEntity> getAllHomework(){
        return homeworkRepositoy.findAll();
    }

    public Optional<HomeworkEntity> getHomeworkById(Long id){
        return homeworkRepositoy.findById(id);
    }

    public HomeworkEntity saveHomework(HomeworkEntity homework){
        return homeworkRepositoy.save(homework);
    }

    public void deleteHomework(Long id){
        homeworkRepositoy.deleteById(id);
    }

}
