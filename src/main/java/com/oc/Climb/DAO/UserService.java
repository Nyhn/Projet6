package com.oc.Climb.DAO;

import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the user interface
 */
@Service
public class UserService {
    @Autowired
    /**
     * Instance of UserRepository
     */
    private UserRepository userRepository;

    /**
     * Get all user
     * @return List of all user
     */
    public List<User> listAll(){ return userRepository.findAll();}

    /**
     * Save a row of user
     * @param user user added
     */
    public void save(User user){ userRepository.save(user);}

    /**
     * Get a user by id
     * @param id if of user
     * @return user by id
     */
    public User get(Long id){ return userRepository.findById(id).get();}

    /**
     * Delete a user by id
     * @param id id of user
     */
    public void delete(Long id){ userRepository.deleteById(id);}

    /**
     * Get a user by pseudo
     * @param pseudo pseudo of user
     * @return user by pseudo
     */
    public User findByPseudo(String pseudo){ return userRepository.findByPseudo(pseudo);}

    /**
     * Get a user by mail
     * @param mail mail of user
     * @return user by mail
     */
    public User findBymail(String mail){ return userRepository.findByMail(mail);}
}
