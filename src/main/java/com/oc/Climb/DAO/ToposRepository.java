package com.oc.Climb.DAO;

import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToposRepository extends JpaRepository<Topos,Long> {
    /**
     * Request SQL
     * @param user user of topos
     * @return list of topos by user
     */
    @Query("SELECT topos FROM Topos topos WHERE topos.user = :user")
    List<Topos> FindToposByUser(@Param("user") User user);

    /**
     * Request SQL
     * @return list of topos available
     */
    @Query("SELECT topos FROM Topos topos WHERE topos.available = true")
    List<Topos> FindToposByAvailable();

    /**
     * Request SQL
     * @param search Pattern of word of search
     * @return list of topos with autor or title with word search
     */
    @Query("SELECT topos FROM Topos topos WHERE (topos.title like %:search% or topos.autor like %:search%) and topos.available = true")
    List<Topos> FindToposBySearch(@Param("search") String search);

    /**
     * Request SQL
     * @param user user of topos
     * @return list of topos available with user topos is not user
     */
    @Query("SELECT topos FROM Topos topos WHERE topos.user <> :user and topos.available = true")
    List<Topos> getAllToposWithOutToposUserAndAvailable(@Param("user") User user);
}
