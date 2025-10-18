package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entity.Equipe;
import tn.esprit.tpprojet.repositories.EquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
    final EquipeRepository equipeRepository;
    @Override
    public Equipe addOrUpdateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe findEquipeById(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public List<Equipe> findAllEquipes() {
        return equipeRepository.findAll();
    }
}
