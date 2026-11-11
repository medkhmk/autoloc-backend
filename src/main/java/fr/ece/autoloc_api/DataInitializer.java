package fr.ece.autoloc_api;

import fr.ece.autoloc_api.domain.CategorieVehicle;
import fr.ece.autoloc_api.domain.StatutVehicle;
import fr.ece.autoloc_api.domain.Vehicule;
import fr.ece.autoloc_api.repository.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository repository) {
        return args -> {
            if (repository.count() == 0) {

                // ===== CITADINES (8) =====
                save(repository, "AB-123-CD", "Renault", "Clio", CategorieVehicle.CITADINE, "50.00");
                save(repository, "EF-456-GH", "Citroën", "C3", CategorieVehicle.CITADINE, "45.00");
                save(repository, "IJ-789-KL", "Volkswagen", "Polo", CategorieVehicle.CITADINE, "60.00");
                save(repository, "MN-012-OP", "Mini", "Cooper", CategorieVehicle.CITADINE, "75.00"); // Utilise MiniM.jpg
                save(repository, "QR-345-ST", "Toyota", "Yaris", CategorieVehicle.CITADINE, "55.00"); // Utilise yaris.jpg
                save(repository, "UV-678-WX", "Peugeot", "208", CategorieVehicle.CITADINE, "55.00"); // Utilise peugeot208.jpg
                save(repository, "YZ-901-AB", "Renault", "Twingo", CategorieVehicle.CITADINE, "40.00"); // Pas d'image, on utilisera une par défaut
                save(repository, "CD-234-EF", "Fiat", "500", CategorieVehicle.CITADINE, "50.00"); // Pas d'image

                // ===== BERLINES (8) =====
                save(repository, "GH-567-IJ", "Mercedes", "Classe C", CategorieVehicle.BERLINE, "150.00"); // Utilise mercedes.jpg
                save(repository, "KL-890-MN", "BMW", "Série 4", CategorieVehicle.BERLINE, "180.00"); // Utilise bmws4.jpg
                save(repository, "OP-123-QR", "Peugeot", "508", CategorieVehicle.BERLINE, "120.00"); // Utilise peugeot508.jpg
                save(repository, "ST-456-UV", "Maserati", "Ghibli", CategorieVehicle.BERLINE, "400.00"); // Utilise maserati.jpg
                save(repository, "WX-789-YZ", "Rolls-Royce", "Ghost", CategorieVehicle.BERLINE, "1200.00"); // Utilise rolls.jpg
                save(repository, "AB-012-CD", "Ferrari", "Roma", CategorieVehicle.BERLINE, "2000.00"); // Utilise ferrari.jpg
                save(repository, "EF-345-GH", "Audi", "A4", CategorieVehicle.BERLINE, "160.00"); // Utilise audia4.jpg
                save(repository, "IJ-678-KL", "Renault", "Talisman", CategorieVehicle.BERLINE, "110.00"); // Utilise talisman.jpg

                // ===== SUV (7) =====
                save(repository, "MN-901-OP", "Peugeot", "3008", CategorieVehicle.SUV, "90.00"); // Utilise peugeot3008.jpg
                save(repository, "QR-234-ST", "Toyota", "RAV4", CategorieVehicle.SUV, "110.00"); // Utilise rav4.jpg
                save(repository, "UV-567-WX", "Mercedes", "G-Class", CategorieVehicle.SUV, "300.00"); // Utilise gclass.jpg
                save(repository, "YZ-890-AB", "Lamborghini", "Urus", CategorieVehicle.SUV, "1500.00"); // Utilise Urus.jpg
                save(repository, "CD-123-EF", "Renault", "Austral", CategorieVehicle.SUV, "100.00"); // Utilise austral.jpg
                save(repository, "GH-456-IJ", "BMW", "X5", CategorieVehicle.SUV, "200.00"); // Utilise bmwx5.jpg
                save(repository, "KL-789-MN", "Audi", "Q5", CategorieVehicle.SUV, "190.00"); // Utilise audiq5.jpg

                // ===== UTILITAIRES (7) =====
                save(repository, "OP-012-QR", "Renault", "Kangoo", CategorieVehicle.UTILITAIRE, "70.00"); // Utilise kangoo.jpg
                save(repository, "ST-345-UV", "Peugeot", "Partner", CategorieVehicle.UTILITAIRE, "75.00"); // Utilise partner.jpg
                save(repository, "WX-678-YZ", "Citroën", "Berlingo", CategorieVehicle.UTILITAIRE, "80.00"); // Utilise berlingo.jpeg
                save(repository, "AB-901-CD", "Ford", "Transit", CategorieVehicle.UTILITAIRE, "95.00"); // Utilise transit.jpeg
                save(repository, "EF-234-GH", "Renault", "Trafic", CategorieVehicle.UTILITAIRE, "100.00"); // Utilise trafic.jpg
                save(repository, "IJ-567-KL", "Mercedes", "Vito", CategorieVehicle.UTILITAIRE, "110.00"); // Utilise mercedesV.jpg
                save(repository, "MN-890-OP", "Porsche", "Macan", CategorieVehicle.UTILITAIRE, "130.00"); // Utilise porsche.jpg (pour éviter les doublons)
            }
        };
    }

    private void save(VehiculeRepository repository, String immat, String marque, String modele, CategorieVehicle categorie, String prix) {
        Vehicule v = new Vehicule();
        v.setImmatriculation(immat);
        v.setMarque(marque);
        v.setModele(modele);
        v.setCategorie(categorie);
        v.setTarifJournalier(new BigDecimal(prix));
        v.setStatut(StatutVehicle.DISPONIBLE);
        repository.save(v);
    }
}