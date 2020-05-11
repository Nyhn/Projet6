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

    /**
     * Get a list of site by place , number of sector, and level
     * @param place place of site
     * @param sector number of sector of site
     * @param level level of site
     * @return list of site by place , number of sector, and level
     */
    public List<Site> findSiteBySearchPlaceAndSectorAndLevel(String place,int sector,Level level){return siteRepository.findSiteBySearchPlaceAndSectorAndLevel(place,sector,level);}

    /**
     * Get a list of site by place , number of sector >= 8, and level
     * @param place place of site
     * @param level level of site
     * @return list of site by place , number of sector >= 8, and level
     */
    public List<Site> findSiteBySearchPlaceAndSectorSuppAndLevel(String place,Level level){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndLevel(place,level);}

    /**
     * Get a list of site by place , number of sector, level and official
     * @param place place of site
     * @param sector Number of sector of site
     * @param level level of site
     * @return list of site by place , number of sector, level and official
     */
    public List<Site> findSiteBySearchPlaceAndSectorAndLevelAndOfficial(String place,int sector,Level level){return siteRepository.findSiteBySearchPlaceAndSectorAndLevelAndOfficial(place,sector,level);}

    /**
     * Get a list of site by place , number of sector >= 8,level and official
     * @param place place of site
     * @param level level of site
     * @return list of site by place , number of sector >= 8,level and official
     */
    public List<Site> findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(String place,Level level){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(place,level);}

    /**
     * Get a List of site by place, number of sector and official
     * @param place place of site
     * @param sector Number of site
     * @return List of site by place, number of sector and official
     */
    public List<Site> findSiteBySearchPlaceAndSectorAndOfficial(String place,int sector){return siteRepository.findSiteBySearchPlaceAndSectorAndOfficial(place,sector);}

    /**
     * Get a List of site by place, number of sector >= 8 and official
     * @param place place of site
     * @return List of site by place, number of sector >= 8 and official
     */
    public List<Site> findSiteBySearchPlaceAndSectorSuppAndOfficial(String place){return siteRepository.findSiteBySearchPlaceAndSectorSuppAndOfficial(place);}

    /**
     * Get a List of site by place, level and official
     * @param place place of site
     * @param level level of site
     * @return List of site by place, level and official
     */
    public List<Site> findSiteBySearchPlaceAndLevelAndOfficial(String place,Level level){return siteRepository.findSiteBySearchPlaceAndLevelAndOfficial(place,level);}

    /**
     * Get a List of site by place and official
     * @param place place of site
     * @return List of site by place and official
     */
    public List<Site> findSiteBySearchPlaceAndOfficial(String place){return siteRepository.findSiteBySearchPlaceAndOfficial(place);}

    /**
     * Get a List of site by level and official
     * @param level level of site
     * @return List of site by level and official
     */
    public List<Site> findSiteBySearchLevelAndOfficial(Level level){return siteRepository.findSiteBySearchLevelAndOfficial(level);}

    /**
     * Get a List of site official
     * @return List of site official
     */
    public List<Site> findSiteBySearchOfficial(){return siteRepository.findSiteBySearchOfficial();}

    /**
     * Get a List of site by number of sector and official
     * @param sector number of sector
     * @return List of site by number of sector and official
     */
    public List<Site> findSiteBySearchSectorAndOfficial(int sector){return siteRepository.findSiteBySearchSectorAndOfficial(sector);}

    /**
     * Get a List of site by number of sector >=8 and official
     * @return List of site by number of sector >=8 and official
     */
    public List<Site> findSiteBySearchSectorSuppAndOfficial(){return siteRepository.findSiteBySearchSectorSuppAndOfficial();}

    /**
     * Get a List of site by sector, level and official
     * @param sector number of sector
     * @param level level of site
     * @return List of site by sector, level and official
     */
    public List<Site> findSiteBySearchSectorAndLevelAndOfficial(int sector,Level level){return siteRepository.findSiteBySearchSectorAndLevelAndOfficial(sector,level);}

    /**
     * Get a List of site by level , number of sector >=8 and official
     * @param level level of site
     * @return List of site by level , number of sector >=8 and official
     */
    public List<Site> findSiteBySearchSectorSuppAndLevelAndOfficial(Level level){return siteRepository.findSiteBySearchSectorSuppAndLevelAndOfficial(level);}

    /**
     * Get a List of site by level
     * @param level level of site
     * @return List of site by level
     */
    public List<Site> findSiteBySearchLevel(Level level){return siteRepository.findSiteBySearchLevel(level);}

    /**
     * Get a List of site by sector
     * @param sector number of sector of site
     * @return List of site by sector
     */
    public List<Site> findSiteBySearchSector(int sector){ return siteRepository.findSiteBySearchSector(sector);}

    /**
     * Get a List of site by sector >=8
     * @return List of site by sector >=8
     */
    public List<Site> findSiteBySearchSectorSupp(){return siteRepository.findSiteBySearchSectorSupp();}

    /**
     * Get a List of site by sector and level
     * @param sector number of sector of site
     * @param level level of site
     * @return List of site by sector and level
     */
    public List<Site> findSiteBySearchSectorAndLevel(int sector,Level level){return siteRepository.findSiteBySearchSectorAndLevel(sector,level);}

    /**
     * Get a List of site by sector>=8 and level
     * @param level level of site
     * @return List of site by sector>=8 and level
     */
    public List<Site> findSiteBySearchSectorSuppAndLevel(Level level){return siteRepository.findSiteBySearchSectorSuppAndLevel(level);}
}
