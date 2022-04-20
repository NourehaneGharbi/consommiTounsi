package tn.consommiTounsi.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.consommiTounsi.spring.entity.Publication;



@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {		

}
