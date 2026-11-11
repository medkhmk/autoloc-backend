package fr.ece.autoloc_api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String accueil() {
        return """
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>AutoLoc - Accueil</title>
                <style>
                    body {
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                        background-color: #0f172a;
                        color: white;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                    }
                    .card {
                        background: rgba(30, 41, 59, 0.7);
                        backdrop-filter: blur(10px);
                        padding: 50px;
                        border-radius: 20px;
                        text-align: center;
                        max-width: 700px;
                        box-shadow: 0px 15px 35px rgba(0,0,0,0.5);
                        border: 1px solid rgba(255,255,255,0.1);
                    }
                    h1 {
                        color: #3b82f6;
                        font-size: 2.5em;
                        margin-bottom: 10px;
                        font-weight: bold;
                    }
                    h2 {
                        color: #94a3b8;
                        font-size: 1.1em;
                        font-weight: normal;
                        margin-bottom: 30px;
                    }
                    .team-grid {
                        display: grid;
                        grid-template-columns: 1fr 1fr;
                        gap: 15px;
                        margin-bottom: 30px;
                    }
                    .team-card {
                        background-color: #334155;
                        padding: 15px;
                        border-radius: 12px;
                        border: 1px solid rgba(255,255,255,0.05);
                        color: #e2e8f0;
                        font-weight: 500;
                    }
                    .badge {
                        display: inline-block;
                        background-color: #10b981;
                        color: white;
                        padding: 8px 16px;
                        border-radius: 20px;
                        font-size: 0.9em;
                        margin-bottom: 20px;
                        box-shadow: 0px 0px 15px rgba(16, 185, 129, 0.5);
                    }
                    .btn-group {
                        display: flex;
                        flex-direction: column;
                        gap: 15px;
                    }
                    .btn {
                        display: block;
                        width: 100%;
                        padding: 15px;
                        background-color: #3b82f6;
                        color: white;
                        text-decoration: none;
                        border-radius: 12px;
                        font-weight: bold;
                        font-size: 1.1em;
                        transition: background-color 0.3s;
                        box-sizing: border-box;
                    }
                    .btn:hover {
                        background-color: #2563eb;
                    }
                    .btn-secondary {
                        background-color: #10b981;
                    }
                    .btn-secondary:hover {
                        background-color: #059669;
                    }
                    .footer {
                        margin-top: 30px;
                        font-size: 0.8em;
                        color: #64748b;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <h1>🏎️ AutoLoc</h1>
                    <h2>Application de gestion de location de véhicules</h2>
                    
                    <p style="color: #94a3b8; font-weight: bold; margin-bottom: 15px;">PROJET RÉALISÉ PAR LE GROUPE</p>
                    
                    <div class="team-grid">
                        <div class="team-card">KHALIFA<br>Mohamed Khalifa</div>
                        <div class="team-card">BASSIS<br>Kenza</div>
                        <div class="team-card">GUNENDRAN<br>Mithulan</div>
                        <div class="team-card">NDIAYE<br>Aïda Martine</div>
                    </div>
                    
                    <div class="badge">✅ Application opérationnelle</div>
                    
                    <div class="btn-group">
                        <a href="/client/categories" class="btn btn-secondary">🚙 Voir les véhicules disponibles</a>
                        <a href="/stats" class="btn">📊 Voir les performances</a>
                    </div>
                    
                    <div class="footer">
                        ECE - Architecture Des Systèmes D'information Et Performance
                    </div>
                </div>
            </body>
            </html>
            """;
    }

    @GetMapping("/client/categories")
    public String categories() {
        return """
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <title>AutoLoc - Catégories</title>
                <style>
                    body {
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                        background: linear-gradient(135deg, #0f172a 0%, #1e1b4b 100%);
                        color: white;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                    }
                    .container {
                        text-align: center;
                        max-width: 900px;
                        width: 100%;
                        padding: 20px;
                    }
                    h1 {
                        color: #60a5fa;
                        font-size: 3em;
                        margin-bottom: 50px;
                        text-shadow: 0 0 20px rgba(96, 165, 250, 0.5);
                    }
                    .grid {
                        display: grid;
                        grid-template-columns: 1fr 1fr;
                        gap: 30px;
                        margin-bottom: 40px;
                    }
                    .btn {
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        gap: 20px;
                        padding: 20px;
                        background: rgba(30, 41, 59, 0.4);
                        backdrop-filter: blur(10px);
                        border: 2px solid rgba(96, 165, 250, 0.3);
                        border-radius: 20px;
                        color: white;
                        text-decoration: none;
                        font-size: 1.5em;
                        font-weight: bold;
                        transition: all 0.4s ease;
                        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
                    }
                    .btn:hover {
                        transform: translateY(-5px) scale(1.02);
                        border-color: #60a5fa;
                        box-shadow: 0 10px 25px rgba(96, 165, 250, 0.3);
                        background: rgba(30, 41, 59, 0.7);
                    }
                    .btn img {
                        width: 100px;
                        height: auto;
                        border-radius: 10px;
                    }
                    .back-link {
                        color: #94a3b8;
                        text-decoration: none;
                        font-size: 1.1em;
                        transition: color 0.3s;
                    }
                    .back-link:hover {
                        color: white;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Choisissez une catégorie</h1>
                    <div class="grid">
                        <!-- Citadine -->
                        <a href="/client/vehicules?categorie=CITADINE" class="btn">
                            <img src="/clio.jpg" alt="Citadine" onerror="this.src='https://via.placeholder.com/100x60?text=Citadine'">
                            Citadine
                        </a>
                        
                        <!-- Berline -->
                        <a href="/client/vehicules?categorie=BERLINE" class="btn">
                            <img src="/mercedes.jpg" alt="Berline" onerror="this.src='https://via.placeholder.com/100x60?text=Berline'">
                            Berline
                        </a>
                        
                        <!-- SUV -->
                        <a href="/client/vehicules?categorie=SUV" class="btn">
                            <img src="/peugeot3008.jpg" alt="SUV" onerror="this.src='https://via.placeholder.com/100x60?text=SUV'">
                            SUV
                        </a>
                        
                        <!-- Utilitaire -->
                        <a href="/client/vehicules?categorie=UTILITAIRE" class="btn">
                            <img src="/kangoo.jpg" alt="Utilitaire" onerror="this.src='https://via.placeholder.com/100x60?text=Utilitaire'">
                            Utilitaire
                        </a>
                    </div>
                    <a href="/" class="back-link">← Retour à l'accueil</a>
                </div>
            </body>
            </html>
            """;
    }
}