package fr.ece.autoloc_api.web.controller;

import fr.ece.autoloc_api.domain.*;
import fr.ece.autoloc_api.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/client")
public class VehiculeController {

    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;

    public VehiculeController(VehiculeRepository v, ClientRepository c, ReservationRepository r) {
        this.vehiculeRepository = v;
        this.clientRepository = c;
        this.reservationRepository = r;
    }

    // 1. Page d'accueil : afficher les véhicules disponibles (SELECT)
    @GetMapping("/vehicules")
    public String listerVehicules(Model model) {
        // SELECT * FROM vehicule WHERE statut = DISPONIBLE
        List<Vehicule> disponibles = vehiculeRepository.findByStatut(StatutVehicle.DISPONIBLE);
        model.addAttribute("vehicules", disponibles);
        return "liste-vehicules"; // Fichier HTML
    }

    // 2. Traiter la location (INSERT Reservation + UPDATE Vehicule)
    @PostMapping("/louer/{id}")
    public String louerVehicule(@PathVariable Long id, @RequestParam String emailClient) {
        // Récupérer le véhicule (SELECT)
        Vehicule v = vehiculeRepository.findById(id).orElseThrow();

        // Récupérer ou créer le client
        Client c = clientRepository.findByEmail(emailClient);
        if (c == null) {
            c = new Client();
            c.setNom("Client"); c.setPrenom("Inconnu");
            c.setEmail(emailClient); c.setTelephone("0000");
            c.setNumPermis("123"); c.setDateInscription(LocalDate.now());
            clientRepository.save(c); // INSERT Client
        }

        // Créer la réservation (INSERT Reservation)
        Reservation r = new Reservation();
        r.setDateDebut(LocalDate.now());
        r.setDateFin(LocalDate.now().plusDays(3));
        r.setStatut(StatutReservation.CONFIRMEE);
        r.setClient(c);
        r.setVehicule(v);
        reservationRepository.save(r);

        // Mettre à jour le statut du véhicule (UPDATE)
        v.setStatut(StatutVehicle.LOUE);
        vehiculeRepository.save(v);

        return "redirect:/client/vehicules?success";
    }
}