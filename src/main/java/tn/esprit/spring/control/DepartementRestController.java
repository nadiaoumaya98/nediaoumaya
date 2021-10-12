package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.repository.IDepartementRepository;



@RestController
public class DepartementRestController {
	
	@Autowired
	IDepartementRepository dR;
	
	@GetMapping("/get-departementname-by-identreprise/{identreprise}")
	@ResponseBody
	public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("identreprise") int idEntreprise){
		return dR.getAllDepartementsNamesByEntreprise(idEntreprise);
	}
	
	@GetMapping("/get-salaire-moy-by-dep/{departementId}")
	@ResponseBody
	public Double getSalaireMoyenByDepartementId(@PathVariable("departementId")long departementId){
		return dR.getSalaireMoyenByDepartementId(departementId);
	}
}
