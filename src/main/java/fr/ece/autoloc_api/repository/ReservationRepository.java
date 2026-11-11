package fr.ece.autoloc_api.repository;

import fr.ece.autoloc_api.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}