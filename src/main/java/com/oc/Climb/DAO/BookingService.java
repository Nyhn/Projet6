package com.oc.Climb.DAO;

import com.oc.Climb.model.Booking;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the booking interface
 */
@Service
public class BookingService {
    /**
     * Instance of BookingRepository
     */
    @Autowired
    private BookingRepository bookingRepository;

    /**
     * function which lists all booking
     * @return List<Booking> set of all reservations
     */
    public List<Booking> listAll(){ return bookingRepository.findAll();}

    /**
     * function which save a row of booking
     * @param booking A reservation saved
     */
    public void save(Booking booking){ bookingRepository.save(booking);}

    /**
     * Get a reservation by id
     * @param id id of booking
     * @return associated booking
     */
    public Booking get(Long id){ return bookingRepository.findById(id).get();}

    /**
     * Delete a booking with id
     * @param id id of booking
     */
    public void delete(Long id){ bookingRepository.deleteById(id);}

    /**
     * Get all booking of our topos
     * @param user user of topos
     * @return List<booking> list of booking
     */
    public List<Booking> findByUserBooking(User user){return bookingRepository.findByUserBooking(user);}

    /**
     * Get all booking of our topos which state is required
     * @param user user of topos
     * @return List<booking> list of booking
     */
    public List<Booking> findByUserBookingRequired(User user){return bookingRepository.findByUserBookingRequired(user);}

    /**
     * Get all booking of our topos which state is accepted
     * @param user user associated with the topos of booking
     * @return Reservation list of the user whose status is accepted
     */
    public List<Booking> getCoordonateUserToposByBookingAccepted(User user){return bookingRepository.getCoordonateUserToposByBookingAccepted(user);}

    /**
     * Get all your reservations accept
     * @param user user associated with the reservation
     * @return Reservation list of the user whose status is accepted
     */
    public List<Booking> getCoordonateUserBookingByBookingAccepted(User user){return bookingRepository.getCoordonateUserBookingByBookingAccepted(user);}

}
