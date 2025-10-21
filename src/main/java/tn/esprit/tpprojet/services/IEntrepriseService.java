package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entity.Entreprise;

import java.util.List;

public interface IEntrepriseService {
    Entreprise addOrUpdateEntreprise(Entreprise e);
    void deleteEntreprise(Long id);
    Entreprise findEntrepriseById(Long id);
    List<Entreprise> findAllEntreprises();
}
