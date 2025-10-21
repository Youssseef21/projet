package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entity.Entreprise;
import tn.esprit.tpprojet.repositories.EntrepriseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EntrepriseImplService implements IEntrepriseService {
    final EntrepriseRepository entrepriseRepository;
    @Override
    public Entreprise addOrUpdateEntreprise(Entreprise e) {
        return entrepriseRepository.save(e);
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public Entreprise findEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).get();
    }

    @Override
    public List<Entreprise> findAllEntreprises() {
        return entrepriseRepository.findAll();
    }
}
