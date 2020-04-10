package com.oc.Climb.model;
import javax.persistence.*;
import java.util.Set;


@Entity
public class User{

    private Long id;
    private String pseudo;
    private String password;
    private String name;
    private String firstname;
    private boolean sex;
    //private Date birth;
    private String address;
    private int zip;
    private String mail;
    private int phone;


    private Set<Topos> toposCollection;

    @OneToMany(mappedBy ="user")
    public Set<Topos> getToposCollection() {
        return toposCollection;
    }

    public void setToposCollection(Set<Topos> toposCollection) {
        this.toposCollection = toposCollection;
    }

    public User() {
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

//    public Date getBirth() {
//        return birth;
//    }
//    public void setBirth(String birth) {
//    }

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
