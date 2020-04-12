package com.oc.Climb.DAO;

import com.oc.Climb.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    private SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository){ this.siteRepository = siteRepository; }

    public List<Site> ListAll(){ return siteRepository.findAll();}

    public void save(Site site){ siteRepository.save(site);}

    public Site get(Long id){ return siteRepository.findById(id).get();}

    public void delete(Long id){ siteRepository.deleteById(id);}
}
