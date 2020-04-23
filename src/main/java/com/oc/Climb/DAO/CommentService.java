package com.oc.Climb.DAO;

import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> listAll(){ return commentRepository.findAll();}

    public void save(Comment comment){ commentRepository.save(comment);}

    public Comment get(Long id){ return commentRepository.findById(id).get();}

    public void delete(Long id){ commentRepository.deleteById(id);}

    public List<Comment> getBySite(Site site){ return commentRepository.findBySite(site);}
}
