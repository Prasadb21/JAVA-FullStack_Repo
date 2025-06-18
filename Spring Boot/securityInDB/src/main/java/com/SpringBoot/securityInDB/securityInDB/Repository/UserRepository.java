package com.SpringBoot.securityInDB.securityInDB.Repository;

import com.SpringBoot.securityInDB.securityInDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findByUsername(String username);
}
