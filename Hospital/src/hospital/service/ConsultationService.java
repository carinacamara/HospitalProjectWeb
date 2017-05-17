package hospital.service;

import java.util.List;

import hospital.model.Consultation;

public interface ConsultationService {
	
	public List<Consultation> getDoc(int idDoctor);
	public List<Consultation> getPatient(int idPatient);
	public List<Consultation> list();
	public void saveOrUpdate(Consultation cons);
	public Consultation getId(int idConsultation);
	public List<Consultation> getDocName(String username);


}
