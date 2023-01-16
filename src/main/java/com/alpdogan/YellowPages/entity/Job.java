package com.alpdogan.YellowPages.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", length = 75)
    private String title;

    @ManyToOne
    @JoinColumn
    private Firm firm;

    @ManyToOne
    @JoinColumn
    private Category category;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

}
