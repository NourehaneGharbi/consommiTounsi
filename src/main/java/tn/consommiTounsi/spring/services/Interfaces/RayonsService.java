package tn.consommiTounsi.spring.services.Interfaces;

import java.util.List;
import java.util.Optional;

import tn.consommiTounsi.spring.entity.Rayons;

public interface RayonsService {

	List<Rayons> retrieveAllRayons();

	Rayons addRayons(Rayons r);

	Rayons updateRayons(Rayons r);
	
    Rayons updateRayonsById(Long id, String type);
	
	Optional < Rayons > findById(Long id);

	void removeRayons(Long id);
}
