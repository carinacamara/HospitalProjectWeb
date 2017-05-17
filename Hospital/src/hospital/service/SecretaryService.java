package hospital.service;

import java.util.List;

import hospital.model.Secretary;

public interface SecretaryService {
	

	public void saveOrUpdate(Secretary sec);
	
	public void delete(int idSecretary);
	
	public Secretary getId(int idSecretary);
	
	public List<Secretary> list();
	

}
