package fr.ece.autoloc_api.web.controller;

import fr.ece.autoloc_api.domain.Vehicule;
import fr.ece.autoloc_api.repository.VehiculeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final VehiculeRepository vehiculeRepository;

    public DashboardController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        model.addAttribute("vehicules", vehicules);
        return "dashboard";
    }
}