package tn.consommiTounsi.spring.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
