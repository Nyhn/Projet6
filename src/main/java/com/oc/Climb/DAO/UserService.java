package com.oc.Climb.DAO;

import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> listAll(){ return userRepository.findAll();}

    public void save(User user){ userRepository.save(user);}

    public User get(Long id){ return userRepository.findById(id).get();}

    public void delete(Long id){ userRepository.deleteById(id);}

    public User findByPseudo(String pseudo){ return userRepository.FindByPseudo(pseudo);}
}
