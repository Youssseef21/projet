package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entity.Projet;
import tn.esprit.tpprojet.repositories.EquipeRepository;
import tn.esprit.tpprojet.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {

    final ProjetRepository projetRepository;

    @Override
    public Projet addOrUpdateProjet(Projet p) {
        return projetRepository.save(p);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<Projet> findAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Projet findProjetById(Long id) {
        return projetRepository.findById(id).get();
    }
}
