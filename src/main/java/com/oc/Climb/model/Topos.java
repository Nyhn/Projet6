package com.oc.Climb.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Topos {
    private Long id;
    private String title;
    private String autor;
    private boolean available;
    private String image;
    private Set<Booking> bookingsCollection;
    private User user;
    private Date date;


    public Topos() {
    }

    @OneToMany(mappedBy ="topos")
    public Set<Booking> getBookingsCollection() {
        return bookingsCollection;
    }
    public void setBookingsCollection(Set<Booking> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
