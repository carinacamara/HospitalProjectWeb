package hospital.dao;

import java.util.List;

import hospital.model.Consultation;

public interface ConsultationDAO {
	
	public List<Consultation> getDoc(int idDoctor);
	public List<Consultation> getPatient(int idPatient);
	public List<Consultation> list();
	public void saveOrUpdate(Consultation cons);
	public Consultation getId(int idConsultation);
	public List<Consultation> getDocName(String username);

	public void sendStuff(int idPatient);
}
