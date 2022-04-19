package tn.consommiTounsi.spring.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.consommiTounsi.spring.entity.Publication;
import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.repository.PublicationRepository;
import tn.consommiTounsi.spring.repository.UserRepository;

@Service
public class PublicationService implements IPublicationService {

	@Autowired
	PublicationRepository publicationRep;

	@Autowired
	UserRepository userRep;




	@Override
	public String AddPublication(int user_id,Publication pub) throws Exception {
		// TODO Auto-generated method stub
		/*List<String> title = publicationRep.findpubtitle();
		List<String> pub_txt = publicationRep.findpubtxt();

		int b=0,c=0;
		for (int i = 1; i <= title.size(); i++) {
			if (pub.getTitle().equalsIgnoreCase(title.get(i-1))) {

				for (int j = 1; j <= pub_txt.size(); j++) {
					if (pub.getPublication_txt().equalsIgnoreCase(pub_txt.get(j-1))) {

						break;

					}
					else {
						if (j == pub_txt.size()) {
							userRep.findById(user_id).map(user -> {



								pub.setUser(user);


								publicationRep.save(pub);
								return user;

							}).get();
							return "publication added succesfully";
						}
					}
				}
				break;
			}
			else{
				if (i == title.size()) {
					userRep.findById(user_id).map(user -> {



						pub.setUser(user);


						publicationRep.save(pub);
						return user;

					}).get();
					return "publication added succesfully";
				}
			}
			
		}*/
		userRep.findById(user_id).map(u ->{
			pub.setUser(u);
			publicationRep.save(pub);
			return u;
		});
		return "pub added successfully";


	}


	@Override
	public List<Publication> RetrievePublication() {
		// TODO Auto-generated method stub
		List<Publication> pub = (List<Publication>) publicationRep.findAll();
		return pub;
	}

	@Override
	public void UpdatePublicationById(Publication pub, int id) {
		// TODO Auto-generated method stub

		this.publicationRep.save(pub);
	}


	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub

		this.publicationRep.deleteById(id);

	}


	@Override
	public Publication GetPubById(int pubId) {
		// TODO Auto-generated method stub

		return publicationRep.findById(pubId).get();

	}


}
