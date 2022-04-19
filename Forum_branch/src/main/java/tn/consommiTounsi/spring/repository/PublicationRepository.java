package tn.consommiTounsi.spring.repository;




import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Publication;
import tn.consommiTounsi.spring.entity.User;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {		

}
