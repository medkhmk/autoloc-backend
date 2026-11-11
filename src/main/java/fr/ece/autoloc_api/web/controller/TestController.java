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
                        background-color: #0f172a; /* Bleu très foncé */
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
                        color: #3b82f6; /* Bleu vif */
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
                        box-shadow: 0px 0px 15px rgba(16, 185, 129, 0.5); /* Effet néon */
                    }
                    .btn-stats {
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
                    .btn-stats:hover {
                        background-color: #2563eb;
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
                    
                    <a href="/stats" class="btn-stats">📊 Voir les performances</a>
                    
                    <div class="footer">
                        ECE - Architecture Des Systèmes D'information Et Performance
                    </div>
                </div>
            </body>
            </html>
            """;
    }
}