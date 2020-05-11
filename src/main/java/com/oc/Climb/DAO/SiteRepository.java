package com.oc.Climb.DAO;

import com.oc.Climb.enums.Level;
import com.oc.Climb.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Long> {
    /**
     * Request SQL
     * @param place Place of site
     * @return List of site by place
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place%")
    List<Site> findSiteBySearchPlace(@Param("place") String place);

    /**
     * Request SQL
     * @param place place of site
     * @param level level of site
     * @return List of site by place and level
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.level = :level")
    List<Site> findSiteBySearchPlaceAndLevel(@Param("place") String place,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @param sector number of sector of site
     * @return list of site by place and sector
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector")
    List<Site> findSiteBySearchPlaceAndSector(@Param("place") String place,@Param("sector") int sector);

    /**
     * Request SQL
     * @param place place of site
     * @return list of site by place and with number of sector >= 8
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8")
    List<Site> findSiteBySearchPlaceAndSectorSupp(@Param("place") String place);

    /**
     * Request SQL
     * @param place place of site
     * @param sector number of sector of site
     * @param level level of site
     * @return list of site by place , number of sector, and level
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.level = :level")
    List<Site> findSiteBySearchPlaceAndSectorAndLevel(@Param("place") String place,@Param("sector") int sector,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @param level level of site
     * @return list of site by place , number of sector >= 8, and level
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.level = :level")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndLevel(@Param("place") String place,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @param sector Number of sector of site
     * @param level level of site
     * @return list of site by place , number of sector, level and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorAndLevelAndOfficial(@Param("place") String place,@Param("sector") int sector,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @param level level of site
     * @return list of site by place , number of sector >= 8,level and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(@Param("place") String place,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @param sector Number of site
     * @return List of site by place, number of sector and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorAndOfficial(@Param("place") String place,@Param("sector") int sector);

    /**
     * Request SQL
     * @param place place of site
     * @return List of site by place, number of sector >= 8 and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndOfficial(@Param("place") String place);

    /**
     * Request SQL
     * @param place place of site
     * @param level level of site
     * @return List of site by place, level and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.level = :level and site.official = true")
    List<Site> findSiteBySearchPlaceAndLevelAndOfficial(@Param("place") String place,@Param("level") Level level);

    /**
     * Request SQL
     * @param place place of site
     * @return List of site by place and official
     */
    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.official = true")
    List<Site> findSiteBySearchPlaceAndOfficial(@Param("place") String place);

    /**
     * Request SQL
     * @param level level of site
     * @return List of site by level and official
     */
    @Query("SELECT site FROM Site site WHERE site.level = :level and site.official = true")
    List<Site> findSiteBySearchLevelAndOfficial(@Param("level") Level level);

    /**
     * Request SQL
     * @return List of site official
     */
    @Query("SELECT site FROM Site site WHERE site.official = true")
    List<Site> findSiteBySearchOfficial();

    /**
     * Request SQL
     * @param sector number of sector
     * @return List of site by number of sector and official
     */
    @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.official = true")
    List<Site> findSiteBySearchSectorAndOfficial(@Param("sector") int sector);

    /**
     * Request SQL
     * @return List of site by number of sector >=8 and official
     */
    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.official = true ")
    List<Site> findSiteBySearchSectorSuppAndOfficial();

    /**
     * Request SQL
     * @param sector number of sector
     * @param level level of site
     * @return List of site by sector, level and official
     */
    @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchSectorAndLevelAndOfficial(@Param("sector") int sector,@Param("level") Level level);

    /**
     * Request SQL
     * @param level level of site
     * @return List of site by level , number of sector >=8 and official
     */
    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchSectorSuppAndLevelAndOfficial(@Param("level") Level level);

    /**
     * Request SQL
     * @param level level of site
     * @return List of site by level
     */
    @Query("SELECT site FROM Site site WHERE site.level = :level")
    List<Site> findSiteBySearchLevel(@Param("level") Level level);

    /**
     * Request SQL
     * @param sector number of sector of site
     * @return List of site by sector
     */
    @Query("SELECT site FROM Site site WHERE site.sector = :sector")
    List<Site> findSiteBySearchSector(@Param("sector") int sector);

    /**
     * Request SQL
     * @return List of site by sector >=8
     */
    @Query("SELECT site FROM Site site WHERE site.sector >= 8")
    List<Site> findSiteBySearchSectorSupp();

    /**
     * Request SQL
     * @param sector number of sector of site
     * @param level level of site
     * @return List of site by sector and level
     */
    @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.level = :level")
    List<Site> findSiteBySearchSectorAndLevel(@Param("sector") int sector,@Param("level") Level level);

    /**
     * Request SQL
     * @param level level of site
     * @return List of site by sector>=8 and level
     */
    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.level = :level")
    List<Site> findSiteBySearchSectorSuppAndLevel(@Param("level") Level level);

}
