package tn.consommiTounsi.spring.services.Implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Commande;
import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.StatBestProd;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.repository.RayonsRepository;

import tn.consommiTounsi.spring.repository.StockRepository;
import tn.consommiTounsi.spring.services.Interfaces.RayonsService;

@Service
public class RayonsServiceImpl implements RayonsService{

	@Autowired
	RayonsRepository rayonsRepository;
	
	@Autowired
	StockServiceImpl stockServiceImpl;
	
	@Autowired
	StockRepository stockRepository;

	
	@Override
	public List<Rayons> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return rayonsRepository.findAll();
	}

	@Override
	public Rayons addRayons(Rayons r) {
		// TODO Auto-generated method stub
		return rayonsRepository.save(r);
	}

	@Override
	public Rayons updateRayons(Rayons r) {
		// TODO Auto-generated method stub
		return rayonsRepository.save(r);
	}
	

	@Override
	public void removeRayons(Long id) {
		// TODO Auto-generated method stub
		rayonsRepository.deleteById(id);
	}

	@Override
	public Optional<Rayons> findById(Long id) {
		// TODO Auto-generated method stub
		return rayonsRepository.findById(id);
	}

	@Override
	public Rayons updateRayonsById(Long id, Rayons r) {
		// TODO Auto-generated method stub
		Rayons rayondb= rayonsRepository.findById(id).get();
		rayondb.setTypeRayons(r.getTypeRayons());
		rayondb.setCategorieProduit(r.getCategorieProduit());
		return rayonsRepository.save(rayondb);
	}
	
	public List<Stock> nbrVenteProdStock(){
		List<Stock> stocks = stockServiceImpl.retrieveAllStocks();
		for(int i=0; i<stocks.size(); i++){
			int nbrCmd = stocks.get(i).getProduit().getCommandes().size();
			stocks.get(i).setNbrCmd(nbrCmd);
			stockRepository.save(stocks.get(i));
		}
	
		return stocks;
	}

	@Override
	public List<StatBestProd> nbrVenteProdCommande(){
		List<StatBestProd> res = new ArrayList<>();
		
		List<Rayons> rayons = retrieveAllRayons();
		
		for(int x=0; x<rayons.size(); x++){
			int nbrCmd=0;
			String nom="";
			for(Stock st: rayons.get(x).getStocks()){
				if(nbrCmd<st.getNbrCmd()){
					nbrCmd=st.getNbrCmd();
					nom=st.getProduit().getLibelleProduit();
					System.out.println(nbrCmd);
				}
			}
			res.add(StatBestProd.of(nbrCmd, nom));
		}
		return res;
			
	}
		
}
	
	

