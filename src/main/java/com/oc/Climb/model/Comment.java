package com.oc.Climb.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Model : comment
 * Comment is a message of user on a site of climb
 * <p>
 *     Comment is characterized by
 *     <ul>
 *         <li>id is a primary key</li>
 *         <li>Text is a message of comment</li>
 *         <li>User is a user connected who write a note</li>
 *         <li>a site where on post a comment</li>
 *     </ul>
 * </p>
 */
@Entity
public class Comment {
    private Long id;
    private String text;
    private User user;
    private Site site;

    public Comment() {
    }
/* GETTERS AND SETTERS */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Size(min=3, max = 2000)
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
