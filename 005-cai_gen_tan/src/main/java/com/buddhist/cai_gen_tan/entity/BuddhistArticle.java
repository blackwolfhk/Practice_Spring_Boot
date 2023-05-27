package com.buddhist.cai_gen_tan.entity;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class BuddhistArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chi_content")
    private String chiContent;

    @Column(name = "eng_content")
    private String engContent;

    // Default constructor
    public BuddhistArticle() {
    }

    // Parameterized constructor
    public BuddhistArticle(String chiContent, String engContent) {
        this.chiContent = chiContent;
        this.engContent = engContent;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChiContent() {
        return chiContent;
    }

    public void setChiContent(String chiContent) {
        this.chiContent = chiContent;
    }

    public String getEngContent() {
        return engContent;
    }

    public void setEngContent(String engContent) {
        this.engContent = engContent;
    }
}
