package hospital.dao;

import java.util.List;

import hospital.model.Doctor;

public interface DoctorDAO {
	
	public void delete(int idDoctor);
	public void saveOrUpdate(Doctor doctor);
	public Doctor getId(int idDoctor);
	public List<Doctor> list();
	

}
