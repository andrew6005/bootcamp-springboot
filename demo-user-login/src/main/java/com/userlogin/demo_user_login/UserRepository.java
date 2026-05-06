package com.userlogin.demo_user_login;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Userentity, Long> {

    Optional<Userentity> findByUsername(String username);
}