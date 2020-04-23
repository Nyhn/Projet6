package com.oc.Climb.model;

import javax.persistence.*;

@Entity
public class Topos {
    private Long id;
    private String title;
    private String autor;
    private boolean available;
    private String image;

    private User user;
    private User userBooking;

    public Topos() {
    }

    @ManyToOne
    @JoinColumn(name="id_userbooking")
    public User getUserBooking() {
        return userBooking;
    }

    public void setUserBooking(User userBooking) {
        this.userBooking = userBooking;
    }

    @ManyToOne
    @JoinColumn(name="id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
