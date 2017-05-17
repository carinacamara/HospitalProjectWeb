package hospital.dao;

import java.util.List;

import hospital.model.Secretary;


public interface SecretaryDAO {
	
	public void saveOrUpdate(Secretary sec);
	
	public void delete(int idSecretary);
	
	public Secretary getId(int idSecretary);
	
	public List<Secretary> list();
	
}
