package com.forge.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue
    private int id;
    //needs to be refined once access to Portfolio is gained
    //@OneToOne
    //private Portfolio portfolio;
    private String university;
    private String degree;
    private String graduationDate;
    private Long gpa;
    private String logoUrl;
    //private Certification certifications

    public Education(String university, String degree, String graduationDate, Long gpa, String logoUrl) {
        this.university = university;
        this.degree = degree;
        this.graduationDate = graduationDate;
        this.gpa = gpa;
        this.logoUrl = logoUrl;
    }

    public Education(String university, String degree, String graduationDate, Long gpa) {
        this.university = university;
        this.degree = degree;
        this.graduationDate = graduationDate;
        this.gpa = gpa;
    }
}
