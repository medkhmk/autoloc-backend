package fr.ece.autoloc_api.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsController {

    @GetMapping("/stats")
    public String showStats() {
        return "stats"; // Le nom du fichier HTML (stats.html)
    }
}