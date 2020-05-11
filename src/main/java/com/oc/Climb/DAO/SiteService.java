package com.oc.Climb.DAO;

import com.oc.Climb.enums.Level;
import com.oc.Climb.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the site interface
 */
@Service
public class SiteService {
    /**
     * Instance of SiteRepository
     */
    @Autowired
    private SiteRepository siteRepository;

    /**
     * Function which list all site
     * @return list<site> list of site
     */
    public List<Site> listAll(){ return siteRepository.findAll();}

    /**
     * Function which save a row of site
     * @param site site added
     */
    public void save(Site site){ siteRepository.save(site);}

    /**
     * Get site by id
     * @param id id of site
     * @return site by id
     */
    public Site get(Long id){ return siteRepository.findById(id).get();}

    /**
     * Delete a site by id
     * @param id
     */
    public void delete(Long id){ siteRepository.deleteById(id);}

    /**
     * Get a list of site by place
     * @param place place of site
     * @return List of site by place
     */
    public List<Site> findSiteBySearchPlace(String place){return siteRepository.findSiteBySearchPlace(place);}

    /**
     * get a list of site by place and level
     * @param place place of site
     * @param level level of site
     * @return List of site by place and level
     */
    public List<Site> findSiteBySearchPlaceAndLevel(String place,Level level){return siteRepository.findSiteBySearchPlaceAndLevel(place,level);}

    /**
     * Get a list of site by place and sector
     * @param place place of site
     * @param sector number of sector of site
     * @return list of site by place and sector
     */
    public List<Site> findSiteBySearchPlaceAndSector(String place,int sector){return siteRepository.findSiteBySearchPlaceAndSector(place,sector);}

    /**
     * Get a list of site by place and with number of sector >= 8
     * @param place place of site
     * @return list of site by place and with number of sector >= 8
     */
    public List<Site> findSiteBySearchPlaceAndSectorSupp(String place){return siteRepository.findSiteBySearchPlaceAndSectorSupp(place);}

    public List<Site> findSiteBySearchPlaceAndSectorAndLevel(String place,int sector,Level level){return siteRepository.findSiteBySearchPlaceAndSectorAndLevel(place,sector,level);}

    public List<Site> findSiteBySearchPlaceAndSectorSuppAndLevel(String place,Level level){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndLevel(place,level);}

    public List<Site> findSiteBySearchPlaceAndSectorAndLevelAndOfficial(String place,int sector,Level level){return siteRepository.findSiteBySearchPlaceAndSectorAndLevelAndOfficial(place,sector,level);}

    public List<Site> findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(String place,Level level){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(place,level);}

    public List<Site> findSiteBySearchPlaceAndSectorAndOfficial(String place,int sector){return siteRepository.findSiteBySearchPlaceAndSectorAndOfficial(place,sector);}

    public List<Site> findSiteBySearchPlaceAndSectorSuppAndOfficial(String place){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndOfficial(place);}

    public List<Site> findSiteBySearchPlaceAndLevelAndOfficial(String place,Level level){return siteRepository.findSiteBySearchPlaceAndLevelAndOfficial(place,level);}

    public List<Site> findSiteBySearchPlaceAndOfficial(String place){return siteRepository.findSiteBySearchPlaceAndOfficial(place);}

    public List<Site> findSiteBySearchLevelAndOfficial(Level level){return siteRepository.findSiteBySearchLevelAndOfficial(level);}

    public List<Site> findSiteBySearchOfficial(){return siteRepository.findSiteBySearchOfficial();}

    public List<Site> findSiteBySearchSectorAndOfficial(int sector){return siteRepository.findSiteBySearchSectorAndOfficial(sector);}

    public List<Site> findSiteBySearchSectorSuppAndOfficial(){return siteRepository.findSiteBySearchSectorSuppAndOfficial();}

    public List<Site> findSiteBySearchSectorAndLevelAndOfficial(int sector,Level level){return siteRepository.findSiteBySearchSectorAndLevelAndOfficial(sector,level);}

    public List<Site> findSiteBySearchSectorSuppAndLevelAndOfficial(Level level){return siteRepository.findSiteBySearchSectorSuppAndLevelAndOfficial(level);}

    public List<Site> findSiteBySearchLevel(Level level){return siteRepository.findSiteBySearchLevel(level);}

    public List<Site> findSiteBySearchSector(int sector){ return siteRepository.findSiteBySearchSector(sector);}

    public List<Site> findSiteBySearchSectorSupp(){return siteRepository.findSiteBySearchSectorSupp();}

    public List<Site> findSiteBySearchSectorAndLevel(int sector,Level level){return siteRepository.findSiteBySearchSectorAndLevel(sector,level);}

    public List<Site> findSiteBySearchSectorSuppAndLevel(Level level){return siteRepository.findSiteBySearchSectorSuppAndLevel(level);}
}
