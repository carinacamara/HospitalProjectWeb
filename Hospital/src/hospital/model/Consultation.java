package hospital.model;

public class Consultation {
	
	private int idConsultation;
	private int idDoctor;
	private int idPatient;
	private int start;
	private boolean done;
	private String observations;
	
	
	public Consultation(){}
	
	
	
	public Consultation(int idDoctor, int idPatient, int start, boolean done, String observations) {
		this.idDoctor = idDoctor;
		this.idPatient = idPatient;
		this.start = start;
		this.done = done;
		this.observations = observations;
	}







	public int getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public int getIdPatient() {
		return idPatient;
	}
	
	
	// aici punem observerul
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	
	
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
	
	

}
