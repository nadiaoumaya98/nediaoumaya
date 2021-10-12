package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.service.IEmployeService;



@RestController
public class EmployeRestController {
	
	@Autowired
	IEmployeService es;
	
	@Autowired
	IEmployeRepository empR;
	
	@PostMapping("/ajouter-employe")
	@ResponseBody
	public int ajouterEmploye(@RequestBody Employe employe){
		return Integer.valueOf(es.ajouterEmploye(employe)).intValue();
	}
	
	@PostMapping("/affect-employe-departement/{idemploye}/{depid}")
	@ResponseBody
	public void affectEmployeADepartement(@PathVariable("idemploye") int employeId,@PathVariable("depid")int depId){
		es.affecterEmployeADepartement(employeId, depId);
		}
	
	@PostMapping("/ajouter-contrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat){
		return es.ajouterContrat(contrat);
	}
	
	@PostMapping("/affect-employe-contrat/{idemploye}/{idcontrat}")
	@ResponseBody
	public void affectContratAEmploye(@PathVariable("idemploye") int employeId,@PathVariable("idcontrat")int contratId){
		es.affecterContratAEmploye(contratId, employeId);
		}
	
	@GetMapping("/count-employe")
	@ResponseBody
	public long getNombreEmploye() {
	return es.getNombreEmploye();
	}
	
	@GetMapping("/count-employe-jpql")
	@ResponseBody
	public long getNombreEmployeJPQL() {
	return empR.getNombreEmployeJPQL();
	}
	
	@GetMapping("/get-employeprenom-by-id/{idemploye}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("idemploye") int employeId){
		return es.getEmployePrenomById(employeId);
		
	}
	
	@GetMapping("/get-all-nameemploye")
	@ResponseBody
	public List<String> getAllEmployeNamesJPQL(){
		return empR.getAllEmployeNamesJPQL();
	}
	
	@GetMapping("/get-all-employe-by-entreprise")
	@ResponseBody
	public List<Employe> getAllEmployeByEntreprise(@RequestBody Entreprise entreprise){
		return empR.getAllEmployeByEntreprisec(entreprise);
	}
}
