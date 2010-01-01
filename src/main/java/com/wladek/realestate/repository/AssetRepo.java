package com.wladek.realestate.repository;

import com.wladek.realestate.domain.realestate.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 1/14/16.
 */
@Repository
public interface AssetRepo extends JpaRepository<Assets , Long> {
}
