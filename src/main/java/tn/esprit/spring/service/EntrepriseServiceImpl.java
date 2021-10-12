package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IEntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

	@Autowired
	IEntrepriseRepository entR;
	
	@Autowired
	IDepartementRepository Dr;

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return Integer.valueOf(entR.save(entreprise).getIdEntreprise().toString());
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		// TODO Auto-generated method stub
		return Integer.valueOf(Dr.save(dep).getIdDepartement().toString());
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// TODO Auto-generated method stub
		Entreprise entreprise=entR.findById(Long.valueOf(entrepriseId)).get();
		Departement departement=Dr.findById(Long.valueOf(depId)).get();
		departement.setEntreprise(entreprise);
		Dr.save(departement);
		
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
