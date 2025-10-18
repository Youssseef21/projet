package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    Equipe addOrUpdateEquipe(Equipe e);
    void deleteEquipe(Long id);
    Equipe findEquipeById(Long id);
    List<Equipe> findAllEquipes();
}
