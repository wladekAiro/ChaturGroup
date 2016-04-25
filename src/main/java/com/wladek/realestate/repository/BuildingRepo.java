package com.wladek.realestate.repository;

import com.wladek.realestate.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 4/23/16.
 */
@Repository
public interface BuildingRepo extends JpaRepository<Building , Long>{
}
