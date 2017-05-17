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
import org.springframework.web.servlet.ModelAndView;

import hospital.model.Doctor;
import hospital.model.Secretary;
import hospital.service.DoctorService;
import hospital.service.SecretaryService;

@Controller
public class AdminPageController {
	
	
	@Autowired
	private SecretaryService secretaryService;
	
	@Autowired
	private DoctorService doctorService;
	

	
	@RequestMapping(value="/admin/listSecretary")
	public ModelAndView listSecretary(ModelAndView model) throws IOException{
		List<Secretary> listSecretary = secretaryService.list();
		model.addObject("listSecretary", listSecretary);
		model.setViewName("listSecretary");
		
		return model;
	}
	
	
	
	@RequestMapping(value = "/admin/newSecretary", method = RequestMethod.GET)
	public ModelAndView newSecretary(ModelAndView model) {
		Secretary newSecretary = new Secretary();	
		model.addObject("secretary", newSecretary);
		model.setViewName("formSecretary");
		return model;
	}
	
	@RequestMapping(value = "/admin/saveSecretary", method = RequestMethod.POST)
	public ModelAndView saveSecretary(ModelAndView model,@Valid @ModelAttribute("secretary") Secretary secretary, BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("formSecretary");
			return model;
		}
		secretaryService.saveOrUpdate(secretary);	
		model.setViewName("redirect:/admin/listSecretary");
		return model;
	}
	
	@RequestMapping(value = "/admin/deleteSecretary", method = RequestMethod.GET)
	public ModelAndView deleteSecretary(HttpServletRequest request) {
		int idSecretary = Integer.parseInt(request.getParameter("idSecretary"));
		secretaryService.delete(idSecretary);
		return new ModelAndView("redirect:/admin/listSecretary");
	}
	
	@RequestMapping(value = "/admin/editSecretary", method = RequestMethod.GET)
	public ModelAndView editSecretary(HttpServletRequest request) {
		int idSecretary = Integer.parseInt(request.getParameter("idSecretary"));
		Secretary secretary = secretaryService.getId(idSecretary);
		ModelAndView model = new ModelAndView("formSecretary");
		model.addObject("secretary", secretary);
		
		return model;
	}
	
	
	
	//DOCTORS
	
	@RequestMapping(value="/admin/listDoctor")
	public ModelAndView listDoctor(ModelAndView model) throws IOException{
		List<Doctor> listDoctor = doctorService.list();
		model.addObject("listDoctor", listDoctor);
		model.setViewName("listDoctor");
		
		return model;
	}
	
	
	@RequestMapping(value = "/admin/newDoctor", method = RequestMethod.GET)
	public ModelAndView newDoctor(ModelAndView model) {
		Doctor newDoctor = new Doctor();	
		model.addObject("doctor", newDoctor);
		model.setViewName("formDoctor");
		return model;
	}
	
	@RequestMapping(value = "/admin/saveDoctor", method = RequestMethod.POST)
	public ModelAndView saveDoctor(ModelAndView model,@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult result) {
		if(result.hasErrors()) {
			model.setViewName("formDoctor");
			return model;
		}
		doctorService.saveOrUpdate(doctor);	
		model.setViewName("redirect:/admin/listDoctor");
		return model;
	}
	
	@RequestMapping(value = "/admin/deleteDoctor", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
		doctorService.delete(idDoctor);
		return new ModelAndView("redirect:/admin/listDoctor");
	}
	
	@RequestMapping(value = "/admin/editDoctor", method = RequestMethod.GET)
	public ModelAndView editDoctor(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
		Doctor doctor = doctorService.getId(idDoctor);
		ModelAndView model = new ModelAndView("formDoctor");
		model.addObject("doctor", doctor);
		
		return model;
	}
	
	
	
	

}
