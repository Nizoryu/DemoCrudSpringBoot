package fr.formation.inti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.inti.repository.EmployeeRepository;

@Controller

public class IndexController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public IndexController() {
	}
	
	@GetMapping("/")
	public String index(Model m, HttpSession session) {
		m.addAttribute("message", "Bonjour Spring boot ! ");
		m.addAttribute("employees", session.getAttribute("employees"));
		return"index";
	}
	
	@GetMapping("/employees")
	public String list(Model m, HttpSession session) {
		session.setAttribute("employees", employeeRepository.findAll());
		return "redirect:/";
	}

}
