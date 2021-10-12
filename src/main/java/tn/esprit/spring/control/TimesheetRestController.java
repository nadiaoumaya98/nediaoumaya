package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.service.IDepartementService;
import tn.esprit.spring.service.IMissionService;
import tn.esprit.spring.service.ITimesheetService;


@RestController
public class TimesheetRestController {
	
	@Autowired
	IDepartementService Ds;
	
	@Autowired
	IMissionService Ms;
	
	@Autowired
	ITimesheetService Ts;

	
	@PostMapping("/ajouter-mission")
	@ResponseBody
	public int ajouterMission(@RequestBody Mission mission){
		return Integer.valueOf(Ts.ajouterMission(mission)).intValue();
	}

	@PostMapping("/affect-mission-departement/{idmission}/{depid}")
	@ResponseBody
	public void affectMissionADepartementTest(@PathVariable("idmission") int missionId,@PathVariable("depid")int depId){
		Ts.affecterMissionADepartement(missionId, depId);
		}
}
