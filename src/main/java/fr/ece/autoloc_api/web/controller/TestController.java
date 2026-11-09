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
                        font-family: Arial, sans-serif;
                        background-color: darkslategray;
                        color: white;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                    }
                    .card {
                        background-color: slategray;
                        padding: 40px;
                        border-radius: 15px;
                        text-align: center;
                        max-width: 600px;
                        box-shadow: 0px 10px 20px rgba(0,0,0,0.5);
                    }
                    h1 {
                        color: black;
                        font-size: 2.5em;
                        margin-bottom: 10px;
                    }
                    h2 {
                        color: whitesmoke;
                        font-size: 1.2em;
                        font-weight: normal;
                        margin-bottom: 30px;
                    }
                    .team {
                        list-style: none;
                        padding: 0;
                        font-size: 1.2em;
                        line-height: 2;
                    }
                    .team li {
                        background-color: lightseagreen;
                        margin: 10px 0;
                        padding: 10px;
                        border-radius: 8px;
                        color: white;
                    }
                    .footer {
                        margin-top: 30px;
                        font-size: 0.9em;
                        color: silver;
                    }
                    .badge {
                        display: inline-block;
                        background-color: crimson;
                        color: black;
                        padding: 8px 15px;
                        border-radius: 20px;
                        font-size: 0.9em;
                        margin-top: 20px;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <h1>🏎️ AutoLoc</h1>
                    <h2>Application de gestion de location de véhicules</h2>
                    <p>Projet réalisé par le groupe :</p>
                    <ul class="team">
                        <li>KHALIFA Mohamed Khalifa</li>
                        <li>BASSIS Kenza</li>
                        <li>GUNENDRAN Mithulan</li>
                        <li>NDIAYE Aïda Martine</li>
                    </ul>
                    <div class="badge">✅ Application opérationnelle</div>
                    <div class="footer">
                        ECE - Architecture Des Système D'information Et Performance
                    </div>
                </div>
            </body>
            </html>
            """;
    }
}