package com.riwi.gestiontareas.repositories;

import com.riwi.gestiontareas.entities.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {
}
