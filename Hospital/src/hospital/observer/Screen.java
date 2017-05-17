package hospital.observer;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.dao.ConsultationDAO;
import hospital.model.Consultation;


public class Screen implements Observer {
	
	//@Autowired
	//ConsultationDAO consDAO;
	
//	int idPatient;

	//public Screen(){}
	
	
	//public Screen(int idPatient) {
//		this.idPatient = idPatient;
//	}


	
	@Override
	public void update(Observable o, Object arg){
		
	//	consDAO.sendStuff(idPatient);
		
	}
	
	
	


	
	

}
