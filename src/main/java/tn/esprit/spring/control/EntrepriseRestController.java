package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.service.IDepartementService;
import tn.esprit.spring.service.IEntrepriseService;

@RestController
public class EntrepriseRestController {
	
	@Autowired
	IEntrepriseService Es;
	
	@PostMapping("/ajouter-entreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Entreprise entreprise){
		return Integer.valueOf(Es.ajouterEntreprise(entreprise)).intValue();
	}
	
	@PostMapping("/ajouter-departement")
	@ResponseBody
	public int ajouterDepartement(@RequestBody Departement dep){
		return Integer.valueOf(Es.ajouterDepartement(dep)).intValue();
	}

	@PostMapping("/affect-departement-entreprise/{depId}/{entrepriseId}")
	@ResponseBody
	public void affectContratAEmploye(@PathVariable("depId") int depId,@PathVariable("entrepriseId")int entrepriseId){
		Es.affecterDepartementAEntreprise(depId, entrepriseId);
		}
}
