package com.oc.Climb.model;

import com.oc.Climb.enums.Level;
import javax.persistence.*;
import java.util.Set;

/**
 * Model : site
 * Site is a spot of climb
 * <p>
 *     Site is characterized by
 *     <ul>
 *         <li>id is a primary key</li>
 *         <li>name is a name of site</li>
 *         <li>place is a location of site</li>
 *         <li>level is a level of site</li>
 *         <li>Orientation is a site exposure</li>
 *         <li>Rocktype is the rock that constitutes the climbing site</li>
 *         <li>Picture is a image link</li>
 *         <li>presentation is a description of site</li>
 *         <li>official is a boolean Official ny the friend of climbing</li>
 *         <li>commentCollection is a set of comment associate to site</li>
 *         <li>sector represents the number of sector</li>
 *     </ul>
 * </p>
 */
@Entity
public class Site {

    private Long id;
    private String name;
    private String place;
    private Level level;
    private String orientation;
    private String rocktype;
    private String picture;
    private String presentation;
    private boolean official;
    private Set<Comment> commentCollection;
    private int sector;


    public Site() {
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getOrientation() {
        return orientation;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getRocktype() {
        return rocktype;
    }
    public void setRocktype(String rocktype) {
        this.rocktype = rocktype;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPresentation() {
        return presentation;
    }
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public boolean isOfficial() {
        return official;
    }
    public void setOfficial(boolean official) {
        this.official = official;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    public int getSector() {
        return sector;
    }
    public void setSector(int sector) {
        this.sector = sector;
    }

    @OneToMany(mappedBy ="site")
    public Set<Comment> getCommentCollection() {
        return commentCollection;
    }
    public void setCommentCollection(Set<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
}
