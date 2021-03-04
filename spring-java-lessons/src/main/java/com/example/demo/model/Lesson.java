package com.example.demo.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliveredOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }
}