package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.consommiTounsi.spring.entity.Publication;

public interface IPublicationService {
	
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub, int id);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
			
}
