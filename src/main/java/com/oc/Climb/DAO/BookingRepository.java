package com.oc.Climb.DAO;

import com.oc.Climb.model.Booking;
import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query("SELECT booking FROM Booking booking WHERE booking.topos = :topos")
    List<Booking> findByTopos(@Param("topos") Topos topos);

    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and topos.user = :user and booking.state = 'REQUIRED'")
    List<Booking> findByUserBookingRequired(@Param("user") User user);

    @Query("SELECT booking FROM Booking booking, Topos topos WHERE booking.topos = topos and topos.user = :user")
    List<Booking> findByUserBooking(@Param("user") User user);
}
