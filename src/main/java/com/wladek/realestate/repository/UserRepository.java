package com.wladek.realestate.repository;

import com.wladek.realestate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wladek
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    User findByLoginId(String loginId);

    User findByEmail(String email);
}
