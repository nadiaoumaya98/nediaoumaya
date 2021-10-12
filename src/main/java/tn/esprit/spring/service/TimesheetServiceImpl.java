package tn.esprit.spring.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IMissionRepository;
import tn.esprit.spring.repository.ITimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService{

	//@Autowired
	//ITimesheetRepository tR;
	
	@Autowired
	IMissionRepository mR;
	
	@Autowired
	IDepartementRepository dR;

	@Override
	public int ajouterMission(Mission mission) {
		// TODO Auto-generated method stub
		return Integer.valueOf(mR.save(mission).getIdMission().toString());
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		// TODO Auto-generated method stub
		Departement departement=dR.findById(Long.valueOf(depId)).orElse(null);
		Mission mission=mR.findById(Long.valueOf(missionId)).get();
		mission.setDepartement(departement);
		mR.save(mission);
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		// TODO Auto-generated method stub
		
	}

}
