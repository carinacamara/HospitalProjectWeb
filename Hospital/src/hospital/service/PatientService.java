package hospital.service;

import java.util.List;

import hospital.model.Patient;

public interface PatientService {
	
	public void saveOrUpdate(Patient pat);
	public List<Patient> list();
	public Patient getId(int idPatient);

}
