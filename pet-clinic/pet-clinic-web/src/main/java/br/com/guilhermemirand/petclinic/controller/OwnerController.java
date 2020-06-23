package br.com.guilhermemirand.petclinic.controller;

import br.com.guilhermemirand.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", this.ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String find() {
        return "not-implemented";
    }
}
