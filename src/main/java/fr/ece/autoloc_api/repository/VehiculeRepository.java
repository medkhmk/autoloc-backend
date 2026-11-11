package fr.ece.autoloc_api.repository;

import fr.ece.autoloc_api.domain.CategorieVehicle;
import fr.ece.autoloc_api.domain.StatutVehicle;
import fr.ece.autoloc_api.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByStatut(StatutVehicle statut);
    List<Vehicule> findByCategorie(CategorieVehicle categorie);
}