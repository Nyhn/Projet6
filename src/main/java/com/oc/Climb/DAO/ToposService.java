package com.oc.Climb.DAO;

import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToposService {
    @Autowired
    private ToposRepository toposRepository;

    public List<Topos> listAll(){ return toposRepository.findAll();}

    public void save(Topos topos){ toposRepository.save(topos);}

    public Topos get(Long id){ return toposRepository.findById(id).get();}

    public void delete(Long id){ toposRepository.deleteById(id);}

    public List<Topos> findToposByUser(User user){ return toposRepository.FindToposByUser(user);}

    public List<Topos> findToposByAvalaible(){ return toposRepository.FindToposByAvailable();}

    public List<Topos> findToposByUserBooking(User user){ return toposRepository.FindToposByUserBooking(user);}

    public List<Topos> findToposBySearch(String search){ return toposRepository.FindToposBySearch(search);}
}
