package com.oc.Climb.DAO;

import com.oc.Climb.model.Booking;
import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> listAll(){ return bookingRepository.findAll();}

    public void save(Booking booking){ bookingRepository.save(booking);}

    public Booking get(Long id){ return bookingRepository.findById(id).get();}

    public void delete(Long id){ bookingRepository.deleteById(id);}

    public List<Booking>  findByTopos(Topos topos){return bookingRepository.findByTopos(topos);}

    public List<Booking> findByUserBooking(User user){return bookingRepository.findByUserBooking(user);}

    public List<Booking> findByUserBookingRequired(User user){return bookingRepository.findByUserBookingRequired(user);}
}
