package hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hospital.dao.ConsultationDAO;
import hospital.model.Consultation;

public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	private ConsultationDAO consDAO;
	
	
	
	@Override
	public List<Consultation> getDoc(int idDoctor) {
		return consDAO.getDoc(idDoctor);
	}

	@Override
	public List<Consultation> getPatient(int idPatient) {
		return consDAO.getPatient(idPatient);
	}

	@Override
	public List<Consultation> list() {
		return consDAO.list();
	}

	@Override
	public void saveOrUpdate(Consultation cons) {
		consDAO.saveOrUpdate(cons);

	}
	@Override
	public Consultation getId(int idConsultation){
		return consDAO.getId(idConsultation);
	}

	@Override
	public List<Consultation> getDocName(String username){
		return consDAO.getDocName(username);
	}
}
