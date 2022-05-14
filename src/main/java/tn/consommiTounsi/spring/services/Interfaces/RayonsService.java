package tn.consommiTounsi.spring.services.Interfaces;

import java.util.List;
import java.util.Optional;

import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.StatBestProd;

public interface RayonsService {

	List<Rayons> retrieveAllRayons();

	Rayons addRayons(Rayons r);

	Rayons updateRayons(Rayons r);
	
    Rayons updateRayonsById(Long id, Rayons r);
	
	Optional < Rayons > findById(Long id);

	void removeRayons(Long id);

	List<StatBestProd> nbrVenteProdCommande();
}
