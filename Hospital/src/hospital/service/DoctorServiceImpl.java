package hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.dao.DoctorDAO;
import hospital.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDAO docDAO;

	@Override
	public void saveOrUpdate(Doctor doc){
		docDAO.saveOrUpdate(doc);
		
	}
	
	@Override
	public void delete(int idDoctor){
		docDAO.delete(idDoctor);
		
	}
	
	@Override
	public Doctor getId(int idDoctor){
		return docDAO.getId(idDoctor);
		
	}
	
	@Override
	public List<Doctor> list(){
		return docDAO.list();
		
	}
	

}
