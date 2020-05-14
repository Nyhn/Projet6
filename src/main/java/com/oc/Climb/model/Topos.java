package com.oc.Climb.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Model : topos
 * Topos is a book of climbing
 * <p>
 *     Topos is characterized by
 *     <ul>
 *         <li>id is a primary key</li>
 *         <li>title is a title of topos</li>
 *         <li>autor is a writer of topos</li>
 *         <li>available is a boolean who represents if a topos is available</li>
 *         <li>image is a picture link</li>
 *         <li>bookingsCollection is a set of bookigs linked to topos</li>
 *         <li>User is the owner of topos</li>
 *         <li>date is the date of publication</li>
 *         <li>description is a summary of the topos</li>
 *     </ul>
 * </p>
 */
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
    private String description;


    public Topos() {
        this.date =  Date.valueOf("0001-01-01");
    }

    /* GETTERS AND SETTERS */
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
