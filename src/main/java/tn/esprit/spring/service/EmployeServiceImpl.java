package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IContratRepository;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IEmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	IEmployeRepository empR;
	
	@Autowired
	IContratRepository cR;
	
	@Autowired
	IDepartementRepository dR;

	@Override
	public int ajouterEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return Integer.valueOf(empR.save(employe).getIdEmploye().toString());
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		// TODO Auto-generated method stub
		Set<Employe> employe=(Set<Employe>) empR.findById(Long.valueOf(employeId)).get();
		Departement departement=dR.findById(Long.valueOf(depId)).get();
		departement.setEmploye(employe);
		dR.save(departement);
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		return Integer.valueOf(cR.save(contrat).getReferenceContrat().toString());
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		// TODO Auto-generated method stub
		Contrat contrat=cR.findById(Long.valueOf(contratId)).get();
		Employe employe=empR.findById(Long.valueOf(employeId)).get();
		employe.setContrat(contrat);
		cR.save(contrat);
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		// TODO Auto-generated method stub
		return String.valueOf( empR.findById(Long.valueOf(employeId)).get().getNomEmploye().toString());
	}

	@Override
	public long getNombreEmploye() {
		// TODO Auto-generated method stub
		return empR.count();
	}
	
}
