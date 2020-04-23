package com.oc.Climb.DAO;

import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Site;
import com.oc.Climb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT comment FROM Comment comment WHERE comment.site = :site")
    List<Comment> findBySite(@Param("site") Site site);
}
