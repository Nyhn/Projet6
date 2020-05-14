package com.oc.Climb.DAO;

import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User,Long> {
    /**
     * Request SQL
     * @param pseudo pseudo of user
     * @return user by pseudo
     */
    @Query("SELECT user FROM User user WHERE user.pseudo = :pseudo")
    User findByPseudo(@Param("pseudo") String pseudo);

    /**
     * Request SQL
     * @param mail mail of user
     * @return user by mail
     */
    @Query("SELECT user FROM User user WHERE user.mail = :mail")
    User findByMail(@Param("mail") String mail);
}
