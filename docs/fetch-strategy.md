# Stratégie de Fetch et Cascade - AutoLoc

Ce document justifie les choix de chargement (Fetch) et de propagation (Cascade) pour les associations du modèle AutoLoc.

| Association | Fetch | Cascade | Justification |
| :--- | :--- | :--- | :--- |
| Contrat → Paiement | LAZY | ALL + orphanRemoval | Les paiements dépendent du contrat et sont supprimés avec lui. |
| Agence → Vehicule | LAZY | None | Les véhicules survivent à la suppression de l'agence. |
| Agence → Employee | LAZY | None | Les employés survivent à la suppression de l'agence. |
| Vehicule ↔ Equipment | LAZY | None | Les équipements sont partagés entre véhicules. |
| Client → Reservation | LAZY | PERSIST | Une réservation est liée à un client. |
| Reservation → Vehicule | LAZY | None | Le véhicule ne dépend pas de la réservation. |
| Reservation ↔ Contrat | LAZY | ALL (côté Reservation) | Le contrat est créé avec la réservation. |
| Vehicule → Maintenance | LAZY | PERSIST | Une maintenance est liée à un véhicule. |