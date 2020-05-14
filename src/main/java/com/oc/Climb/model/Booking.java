package com.oc.Climb.model;

import com.oc.Climb.enums.State;

import javax.persistence.*;
import java.util.Date;

/**
 * Model : booking
 * Booking is a reservation of topos
 * <p>
 *     Booking is characterized by
 *     <ul>
 *         <li>id is a primary key</li>
 *         <li>user is an user who books a topos</li>
 *         <li>topos is an topos who is reserved</li>
 *         <li>state is a state of booking</li>
 *         <li>date is request date of booking </li>
 *     </ul>
 * </p>
 */
@Entity
public class Booking {

    private Long id;
    private User user;
    private Topos topos;
    /**
     * Enum State : REQUIRED, ACCEPTED, REFUSE
     */
    private State state;
    private Date date;

    public Booking() {
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

    @ManyToOne
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id_topos")
    public Topos getTopos() {
        return topos;
    }
    public void setTopos(Topos topos) {
        this.topos = topos;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    @Column(name = "date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
