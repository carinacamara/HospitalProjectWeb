package hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.dao.PatientDAO;
import hospital.model.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientDAO patientDAO;
	
	@Override
	public void saveOrUpdate(Patient pat){
		patientDAO.saveOrUpdate(pat);
		
	}
	
	@Override
	public List<Patient> list(){
		return patientDAO.list();
	}
	
	@Override
	public Patient getId(int idPatient){
		return patientDAO.getId(idPatient);
	}
	

}
