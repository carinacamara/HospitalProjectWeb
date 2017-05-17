package hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.dao.SecretaryDAO;
import hospital.model.Secretary;

@Service
public class SecretaryServiceImpl implements SecretaryService {
	
	@Autowired
	private SecretaryDAO secDAO;

	@Override
	public void saveOrUpdate(Secretary sec){
		secDAO.saveOrUpdate(sec);
		
	}
	
	@Override
	public void delete(int idSecretary){
		secDAO.delete(idSecretary);
		
	}
	
	@Override
	public Secretary getId(int idSecretary){
		return secDAO.getId(idSecretary);
		
	}
	
	@Override
	public List<Secretary> list(){
		return secDAO.list();
		
	}
	
	

}
