package com.riwi.gestiontareas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "homework")
public class HomeworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "time_creation", nullable = false)
    private LocalTime timeCreation;

    @Column(length = 50, nullable = false)
    private String status;

    public HomeworkEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalTime getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(LocalTime timeCreation) {
        this.timeCreation = timeCreation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
