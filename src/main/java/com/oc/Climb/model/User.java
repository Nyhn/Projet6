package com.oc.Climb.model;
import com.oc.Climb.enums.Role;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
public class User{

    private Long id;
    private String pseudo;
    private String password;
    private String name;
    private String firstname;
    private boolean sex;
    private String address;
    private int zip;
    private String mail;
    private int phone;
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if(role.equals(Role.ADMINISTRATOR))
            this.role = Role.ADMINISTRATOR;
        if(role.equals(Role.MEMBER))
            this.role = Role.MEMBER;
        if(role.equals(Role.USER))
            this.role = Role.USER;
    }

    private Set<Topos> toposCollection;

    private Set<Comment> commentCollection;

    @OneToMany(mappedBy ="user")
    public Set<Booking> getBookingsCollection() {
        return bookingsCollection;
    }
    public void setBookingsCollection(Set<Booking> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    private Set<Booking> bookingsCollection;

    @OneToMany(mappedBy ="user")
    public Set<Comment> getCommentCollection() {
        return commentCollection;
    }
    public void setCommentCollection(Set<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @OneToMany(mappedBy ="user")
    public Set<Topos> getToposCollection() {
        return toposCollection;
    }
    public void setToposCollection(Set<Topos> toposCollection) {
        this.toposCollection = toposCollection;
    }

    public User() {
        this.pseudo = "";
        this.password = "";
        this.name = "";
        this.firstname = "";
        this.sex = false;
        this.address = "";
        this.zip = -1;
        this.mail = "";
        this.phone = -1;
        this.role = Role.NOT_CONNECTED;
    }


    public User(String pseudo, String password, String name, String firstname, boolean sex, String address, int zip, int phone, String mail) {
        this.pseudo = pseudo;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.sex = sex;
        this.address = address;
        this.zip = zip;
        this.mail = mail;
        this.phone = phone;
        this.role = Role.USER;
    }

    /* ----- GETTER AND SETTER ----- */

    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo){
        if(pseudo.length() > 50){}

        else
            this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
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

}
