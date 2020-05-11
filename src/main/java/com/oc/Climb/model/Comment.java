package com.oc.Climb.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Comment {
    private Long id;
    private String text;
    private User user;
    private Site site;

    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id_site")
    public Site getSite() {
        return site;
    }
    public void setSite(Site site) {
        this.site = site;
    }
}
