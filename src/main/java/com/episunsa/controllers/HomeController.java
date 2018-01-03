package com.episunsa.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/* CLASE para responder a Solicitudes  desde HOME */

@Controller
public class HomeController {
	/* Request para pagina principal */
	@RequestMapping(value= {"/","/welcome"}, method=RequestMethod.GET ,produces="text/html;charset=UTF-8")
	public String welcomePage(Model model) {
        model.addAttribute("title", "Bienvenido");
        model.addAttribute("message", "Matriculas Laboratorio EPISUNSA");
        return "index";
    }
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "adminPage";
    }
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentPage(Model model) {
        return "student";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
         
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName();
 
        System.out.println("Nombre de usuario: "+ userName);
 
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
         
        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> No tienes permisos para acceder a esta página!");
        } else {
            model.addAttribute("msg",
                    "No tienes permisos para acceder a esta página!");
        }
        return "403Page";
    }
}
