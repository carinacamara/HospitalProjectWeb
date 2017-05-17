package hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hospital.dao.ConsultationDAO;
import hospital.model.Consultation;
import hospital.model.Patient;
import hospital.observer.DataStore;
import hospital.observer.Screen;
import hospital.service.PatientService;

@Controller
public class SecretaryPageController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	//private ConsultationService consultationService;
	private ConsultationDAO consDAO;
	
	@RequestMapping(value = "/secretary/listPatient")
	public ModelAndView listPatient(){
		
		ModelAndView model = new ModelAndView("listPatient");
		List<Patient> listPatient = patientService.list();
		model.addObject("listPatient", listPatient);
		return model;
	}
	
	@RequestMapping(value = "/secretary/newPatient", method = RequestMethod.GET)
	public ModelAndView newPatient(){
		ModelAndView model = new ModelAndView();
		Patient patient = new Patient();
		model.addObject("patient", patient);
		model.setViewName("formPatient");
		return model;
		
	}
	
	@RequestMapping(value = "/secretary/savePatient", method = RequestMethod.POST)
	public ModelAndView savePatient(ModelAndView model,@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
		
		if(result.hasErrors()) {
			model.setViewName("formPatient");
			return model;
		
		}
		patientService.saveOrUpdate(patient);	
		model.setViewName("redirect:/secretary/listPatient");
		return model;
	}
	
	@RequestMapping(value = "/secretary/editPatient", method = RequestMethod.GET)
	public ModelAndView editPatient(HttpServletRequest request) {
		int idPatient = Integer.parseInt(request.getParameter("idPatient"));
		Patient patient = patientService.getId(idPatient);
		ModelAndView model = new ModelAndView("formPatient");
		model.addObject("patient", patient);
		
		return model;
	}
	
	//Make appointments
	
	//pagina unde cerem idDoctor
	@RequestMapping(value = "/secretary/searchDoctor", method = RequestMethod.GET)
	public ModelAndView showSearchPage(ModelAndView model) throws IOException{
		
		model.setViewName("formSearch");
		
		return model;
	}
	
	//pagina unde listam Consultatiile
	
	@RequestMapping(value="/secretary/listConsultation")
	public ModelAndView listConsultation(ModelAndView model, @RequestParam int idDoctor) throws IOException{
		
		model.addObject("idDoctor",idDoctor);

		List<Consultation> listCons = consDAO.getDoc(idDoctor);
		
		model.addObject("listConsultation", listCons);
		model.setViewName("listConsultation");
		
		return model;
	}
	

	//form pentru editare
	
	@RequestMapping(value = "/secretary/saveConsultation", method = RequestMethod.POST)
	public ModelAndView saveConsultation(ModelAndView model,@Valid @ModelAttribute("consultation") Consultation consultation, BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("formConsultation");
			return model;
		}
		consDAO.saveOrUpdate(consultation);	
		model.setViewName("redirect:/secretary");
		return model;
	}
	
	@RequestMapping(value = "/secretary/editConsultation", method = RequestMethod.GET)
	public ModelAndView editConsultation(HttpServletRequest request) {
		int idConsultation = Integer.parseInt(request.getParameter("idConsultation"));
		Consultation consultation = consDAO.getId(idConsultation);
		ModelAndView model = new ModelAndView("formConsultation");
		model.addObject("consultation", consultation);
		
		return model;
	}
	
	
	//Check in patient
	// aici cerem idPatient
	@RequestMapping(value = "/secretary/checkIn", method = RequestMethod.GET)
	public ModelAndView showCheckInPage(ModelAndView model) throws IOException{
		
		model.setViewName("formCheck");
		
		return model;
	}
	
	// trimitem notificarea cu idPatient si facem setarile pr observator
	@RequestMapping(value="/secretary/doneCheck")
	public ModelAndView doneCheck(ModelAndView model, @RequestParam int idPatient) throws IOException{
		
	//	Screen screen = new Screen(idPatient);
		
		Screen screen = new Screen();
		
		DataStore dataStore = new DataStore();
		
		dataStore.addObserver(screen);
		
		dataStore.setState(1);

		
		dataStore.notifyObservers();

		consDAO.sendStuff(idPatient);
		
		model.addObject("message","Notification sent! ");
	
		model.setViewName("doneCheck");
		
		return model;
	}

}
