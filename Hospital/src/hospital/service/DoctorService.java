package hospital.service;

import java.util.List;

import hospital.model.Doctor;


public interface DoctorService {
	
public void saveOrUpdate(Doctor doc);
	
	public void delete(int idDoctor);
	
	public Doctor getId(int idDoctor);
	
	public List<Doctor> list();

}
