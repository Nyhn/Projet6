package com.oc.Climb.DAO;

import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the comment interface
 */
@Service
public class CommentService {
    /**
     * Instance of CommentRepository
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * function which lists all comment
     * @return List<Comment> set of all comments
     */
    public List<Comment> listAll(){ return commentRepository.findAll();}

    /**
     * Function which save a row of comment
     * @param comment a comment saved
     */
    public void save(Comment comment){ commentRepository.save(comment);}

    /**
     * Get a comment by id
     * @param id id of comment
     * @return a comment
     */
    public Comment get(Long id){ return commentRepository.findById(id).get();}

    /**
     * Delete a comment by id
     * @param id id of comment
     */
    public void delete(Long id){ commentRepository.deleteById(id);}

    /**
     * Get all comment associate with a site
     * @param site site of comments
     * @return List<Comment> list of comment of site
     */
    public List<Comment> getBySite(Site site){ return commentRepository.findBySite(site);}
}
