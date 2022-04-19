package tn.consommiTounsi.spring.services;

import java.util.List;

import tn.consommiTounsi.spring.entity.LikePosts;
import tn.consommiTounsi.spring.entity.Publication;
import tn.consommiTounsi.spring.entity.User;

public interface ILikeService {
	
	public void AddLike(LikePosts likes, int user_id,int pub_id);
	public List<LikePosts> GetLikes();
	public void AddDislike(LikePosts likes, int user_id,int pub_id);
	public void Deletelike(int user_id,int pub_id);
	public void DeleteDislike(int user_id,int com_id);
	
	

}
