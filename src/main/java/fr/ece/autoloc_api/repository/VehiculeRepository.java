package fr.ece.autoloc_api.repository;

import fr.ece.autoloc_api.domain.Vehicule;
import fr.ece.autoloc_api.domain.StatutVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    // SELECT * FROM vehicule WHERE statut = 'DISPONIBLE'
    List<Vehicule> findByStatut(StatutVehicle statut);
}