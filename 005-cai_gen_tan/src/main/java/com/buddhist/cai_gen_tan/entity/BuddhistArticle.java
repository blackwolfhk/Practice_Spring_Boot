package com.buddhist.cai_gen_tan.entity;

import jakarta.persistence.*;

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

    @Column(name = "title")
    private String title;

    // Getters and setters
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
