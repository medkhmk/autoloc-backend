package fr.ece.autoloc_api.web.controller;

import fr.ece.autoloc_api.domain.*;
import fr.ece.autoloc_api.repository.ClientRepository;
import fr.ece.autoloc_api.repository.ReservationRepository;
import fr.ece.autoloc_api.service.VehiculeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/client")
public class VehiculeController {

    private final VehiculeService vehiculeService;
    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;

    public VehiculeController(VehiculeService vehiculeService, ClientRepository clientRepository, ReservationRepository reservationRepository) {
        this.vehiculeService = vehiculeService;
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
    }

    // 1. Page d'accueil : afficher les véhicules (filtrés par catégorie ou tous)
    @GetMapping("/vehicules")
    public String listerVehicules(@RequestParam(required = false) CategorieVehicle categorie, Model model) {
        List<Vehicule> vehicules;
        if (categorie != null) {
            // Si une catégorie est choisie, on filtre
            vehicules = vehiculeService.findByCategorie(categorie);
        } else {
            // Sinon, on affiche tous les véhicules disponibles
            vehicules = vehiculeService.findDisponibles();
        }
        model.addAttribute("vehicules", vehicules);
        return "liste-vehicules";
    }

    // 2. Traiter la location (INSERT Reservation + UPDATE Vehicule)
    @PostMapping("/louer/{id}")
    public String louerVehicule(@PathVariable Long id, @RequestParam String emailClient) {
        // Récupérer le véhicule via le Service
        Vehicule v = vehiculeService.findById(id);

        // Récupérer ou créer le client
        Client c = clientRepository.findByEmail(emailClient);
        if (c == null) {
            c = new Client();
            c.setNom("Client"); c.setPrenom("Inconnu");
            c.setEmail(emailClient); c.setTelephone("0000");
            c.setNumPermis("123"); c.setDateInscription(LocalDate.now());
            clientRepository.save(c);
        }

        // Créer la réservation
        Reservation r = new Reservation();
        r.setDateDebut(LocalDate.now());
        r.setDateFin(LocalDate.now().plusDays(3));
        r.setStatut(StatutReservation.CONFIRMEE);
        r.setClient(c);
        r.setVehicule(v);
        reservationRepository.save(r);

        // Mettre à jour le statut du véhicule
        v.setStatut(StatutVehicle.LOUE);
        vehiculeService.save(v);

        return "redirect:/client/vehicules?success";
    }
}