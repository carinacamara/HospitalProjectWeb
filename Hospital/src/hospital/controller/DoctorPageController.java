package hospital.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hospital.dao.ConsultationDAO;
import hospital.model.Consultation;
import hospital.model.Doctor;
import hospital.observer.DataStore;
import hospital.observer.Screen;
import hospital.service.ConsultationService;


@Controller
public class DoctorPageController {
	
	@Autowired
	ConsultationDAO consDAO;

	
	
	@RequestMapping(value="/doctor/listConsultation")
	public ModelAndView listConsultation(ModelAndView model) throws IOException{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    
	    List<Consultation> listCons =consDAO.getDocName(name);
	    				
	
		model.addObject("listConsultation", listCons);
		model.setViewName("listConsultationDoc");
		
		return model;
	}
	
	@RequestMapping(value = "/doctor/saveConsultation", method = RequestMethod.POST)
	public ModelAndView saveConsultation(ModelAndView model,@Valid @ModelAttribute("consultation") Consultation consultation, BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("formConsultationDoc");
			return model;
		}
		consDAO.saveOrUpdate(consultation);	
		model.setViewName("redirect:/doctor");
		return model;
	}
	
	@RequestMapping(value = "/doctor/editConsultation", method = RequestMethod.GET)
	public ModelAndView editConsultation(HttpServletRequest request) {
		int idConsultation = Integer.parseInt(request.getParameter("idConsultation"));
		Consultation consultation = consDAO.getId(idConsultation);
		ModelAndView model = new ModelAndView("formConsultationDoc");
		model.addObject("consultation", consultation);
		
		return model;
	}
	
	//pagina unde cerem idPatient
		@RequestMapping(value = "/doctor/searchPatient", method = RequestMethod.GET)
		public ModelAndView showSearchPage(ModelAndView model) throws IOException{
			
			model.setViewName("formSearchPatient");
			
			return model;
		}
		
		//pagina unde listam Consultatiile
		
		@RequestMapping(value="/doctor/listConsultationPatient")
		public ModelAndView listConsultation(ModelAndView model, @RequestParam int idPatient) throws IOException{
			
			model.addObject("idPatient",idPatient);

			List<Consultation> listCons = consDAO.getPatient(idPatient);
			
			model.addObject("listConsultation", listCons);
			model.setViewName("listConsultationPatient");
			
			return model;
		}
}
