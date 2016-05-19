package com.wladek.realestate.repository;

import com.wladek.realestate.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 1/1/10.
 */
@Repository
public interface ShopRepo extends JpaRepository<Shop , Long>{
}
