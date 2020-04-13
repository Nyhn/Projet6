package com.oc.Climb.DAO;

import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToposRepository extends JpaRepository<Topos,Long> {
    @Query("SELECT topos FROM Topos topos WHERE topos.user = :user")
    List<Topos> FindToposByUser(@Param("user") User user);
}
