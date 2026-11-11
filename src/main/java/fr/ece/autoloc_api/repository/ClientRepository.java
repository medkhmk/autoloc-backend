package fr.ece.autoloc_api.repository;

import fr.ece.autoloc_api.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Optionnel : trouver un client par son email
    Client findByEmail(String email);
}