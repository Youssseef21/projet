package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entity.Projet;

import java.util.List;

public interface IProjetService {
    Projet addOrUpdateProjet(Projet p);
    void deleteProjet(Long id);
    List<Projet> findAllProjets();
    Projet findProjetById(Long id);
}
