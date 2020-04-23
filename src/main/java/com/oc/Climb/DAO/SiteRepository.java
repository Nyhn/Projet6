package com.oc.Climb.DAO;

import com.oc.Climb.enums.Level;
import com.oc.Climb.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Long> {
    @Query("SELECT site FROM Site site WHERE site.place like %:place%")
    List<Site> findSiteBySearchPlace(@Param("place") String place);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.level = :level")
    List<Site> findSiteBySearchPlaceAndLevel(@Param("place") String place,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector")
    List<Site> findSiteBySearchPlaceAndSector(@Param("place") String place,@Param("sector") int sector);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8")
    List<Site> findSiteBySearchPlaceAndSectorSupp(@Param("place") String place);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.level = :level")
    List<Site> findSiteBySearchPlaceAndSectorAndLevel(@Param("place") String place,@Param("sector") int sector,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.level = :level")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndLevel(@Param("place") String place,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorAndLevelAndOfficial(@Param("place") String place,@Param("sector") int sector,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(@Param("place") String place,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector = :sector and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorAndOfficial(@Param("place") String place,@Param("sector") int sector);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.sector >= 8 and site.official = true ")
    List<Site> findSiteBySearchPlaceAndSectorSuppAndOfficial(@Param("place") String place);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.level = :level and site.official = true")
    List<Site> findSiteBySearchPlaceAndLevelAndOfficial(@Param("place") String place,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.place like %:place% and site.official = true")
    List<Site> findSiteBySearchPlaceAndOfficial(@Param("place") String place);

    @Query("SELECT site FROM Site site WHERE site.level = :level and site.official = true")
    List<Site> findSiteBySearchLevelAndOfficial(@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.official = true")
    List<Site> findSiteBySearchOfficial();

   @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.official = true")
    List<Site> findSiteBySearchSectorAndOfficial(@Param("sector") int sector);

    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.official = true ")
    List<Site> findSiteBySearchSectorSuppAndOfficial();

    @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchSectorAndLevelAndOfficial(@Param("sector") int sector,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.level = :level and site.official = true ")
    List<Site> findSiteBySearchSectorSuppAndLevelAndOfficial(@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.level = :level")
    List<Site> findSiteBySearchLevel(@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.sector = :sector")
    List<Site> findSiteBySearchSector(@Param("sector") int sector);

    @Query("SELECT site FROM Site site WHERE site.sector >= 8")
    List<Site> findSiteBySearchSectorSupp();

    @Query("SELECT site FROM Site site WHERE site.sector = :sector and site.level = :level")
    List<Site> findSiteBySearchSectorAndLevel(@Param("sector") int sector,@Param("level") Level level);

    @Query("SELECT site FROM Site site WHERE site.sector >= 8 and site.level = :level")
    List<Site> findSiteBySearchSectorSuppAndLevel(@Param("level") Level level);


}
