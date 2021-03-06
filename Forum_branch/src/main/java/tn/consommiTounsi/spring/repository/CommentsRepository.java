package tn.consommiTounsi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {	
	@Query(value="SELECT comments.* from comments join like_comments on comments.id = like_comments.com_id where pub_id_id = :publicationId GROUP by like_comments.com_id order by COUNT(like_comments.com_id) DESC",nativeQuery=true)
	List<Comments> RelevantComments(@Param("publicationId") int id);
}
