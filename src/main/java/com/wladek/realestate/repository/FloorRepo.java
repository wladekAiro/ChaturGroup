package com.wladek.realestate.repository;

import com.wladek.realestate.domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 4/26/16.
 */
@Repository
public interface FloorRepo extends JpaRepository<Floor , Long> {
}
