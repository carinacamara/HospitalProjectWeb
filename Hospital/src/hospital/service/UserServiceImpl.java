package hospital.service;

import org.springframework.beans.factory.annotation.Autowired;

import hospital.dao.UserDAO;
import hospital.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public User find(String username){
		return userDAO.find(username);
	}

}
