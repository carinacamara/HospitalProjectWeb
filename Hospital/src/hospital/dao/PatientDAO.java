package hospital.dao;

import java.util.List;

import hospital.model.Patient;

public interface PatientDAO {
	
	public void saveOrUpdate(Patient pat);
	public List<Patient> list();
	public Patient getId(int idPatient);

}
