package tn.consommiTounsi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.ERole;
import tn.consommiTounsi.spring.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

	Role findByName(ERole roleAdmin);

}