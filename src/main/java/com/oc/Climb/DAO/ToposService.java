package com.oc.Climb.DAO;

import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the topos interface
 */
@Service
public class ToposService {
    /**
     * Instance of ToposRepository
     */
    @Autowired
    private ToposRepository toposRepository;

    /**
     * Get all topos
     * @return list of topos
     */
    public List<Topos> listAll(){ return toposRepository.findAll();}

    /**
     * Save a row of topos
     * @param topos topos added
     */
    public void save(Topos topos){ toposRepository.save(topos);}

    /**
     * Get a topos by id
     * @param id id of topos
     * @return a topos by id
     */
    public Topos get(Long id){ return toposRepository.findById(id).get();}

    /**
     * delete a topos by id
     * @param id id of topos
     */
    public void delete(Long id){ toposRepository.deleteById(id);}

    /**
     * Get a list of topos by user
     * @param user user of topos
     * @return list of topos by user
     */
    public List<Topos> findToposByUser(User user){ return toposRepository.FindToposByUser(user);}

    /**
     * Get a list of topos available
     * @return list of topos available
     */
    public List<Topos> findToposByAvalaible(){ return toposRepository.FindToposByAvailable();}

    /**
     * Get a list of topos with autor or title with word search
     * @param search Pattern of word of search
     * @return list of topos with autor or title with word search
     */
    public List<Topos> findToposBySearch(String search){ return toposRepository.FindToposBySearch(search);}

    /**
     * Get a list of topos available with user topos is not user
     * @param user user of topos
     * @return list of topos available with user topos is not user
     */
    public List<Topos> getAllToposWithOutToposUserAndAvailable(User user){return toposRepository.getAllToposWithOutToposUserAndAvailable(user);}
}
