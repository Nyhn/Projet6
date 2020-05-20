package com.oc.Climb.DAO;

import com.oc.Climb.model.Booking;
import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * DAO interface interacting with the booking table
 */
public interface BookingRepository extends JpaRepository<Booking,Long> {
    /**
     * SQL request
     * @param user user associated with the reservation
     * @return Reservation list of the user whose status is pending
     */
    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and topos.user = :user and booking.state = 'REQUIRED'")
    List<Booking> findByUserBookingRequired(@Param("user") User user);

    /**
     * SQL REQUEST
     * @param user user associated with the reservation
     * @return Reservation list of the user
     */
    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and topos.user = :user")
    List<Booking> findByUserBooking(@Param("user") User user);

    /**
     * SQL REQUEST
     * @param user user associated with the topos of booking
     * @return Reservation list of the user whose status is accepted
     */
    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and topos.user = :user and booking.state = 'ACCEPTED'")
    List<Booking> getCoordonateUserToposByBookingAccepted(@Param("user") User user);

    /**
     * SQL REQUEST
     * @param user user associated with the reservation
     * @return Reservation list of the user whose status is accepted
     */
    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and booking.user = :user and booking.state = 'ACCEPTED'")
    List<Booking> getCoordonateUserBookingByBookingAccepted(@Param("user") User user);
}
