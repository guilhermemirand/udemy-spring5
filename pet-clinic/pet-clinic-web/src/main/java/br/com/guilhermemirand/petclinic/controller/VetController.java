package br.com.guilhermemirand.petclinic.controller;

import br.com.guilhermemirand.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    @RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html"})
    public String getAllVets(Model model) {
        model.addAttribute("vets", this.vetService.findAll());
        return "vets/index";
    }
}
