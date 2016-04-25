package com.wladek.realestate.repository;

import com.wladek.realestate.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 1/1/10.
 */
@Repository
public interface PropertyRepo  extends JpaRepository<Property , Long> {
}
