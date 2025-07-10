package com.SpringBoot.dockerDemo_SB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {


}
