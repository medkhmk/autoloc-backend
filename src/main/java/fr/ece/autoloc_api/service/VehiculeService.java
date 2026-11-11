package fr.ece.autoloc_api.service;

import fr.ece.autoloc_api.domain.CategorieVehicle;
import fr.ece.autoloc_api.domain.StatutVehicle;
import fr.ece.autoloc_api.domain.Vehicule;
import fr.ece.autoloc_api.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> findDisponibles() {
        return vehiculeRepository.findByStatut(StatutVehicle.DISPONIBLE);
    }

    public List<Vehicule> findByCategorie(CategorieVehicle categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }

    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id).orElseThrow();
    }

    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}