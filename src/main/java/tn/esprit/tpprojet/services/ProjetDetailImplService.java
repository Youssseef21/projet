package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entity.ProjetDetail;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjetDetailImplService implements IProjetdetailService {
    final IProjetdetailService projetDetailRepository;
    @Override
    public ProjetDetail addOrUpdateProjetDetail(ProjetDetail pd) {
        return projetDetailRepository.addOrUpdateProjetDetail(pd);
    }

    @Override
    public void deleteProjetDetail(Long id) {
        projetDetailRepository.deleteProjetDetail(id);

    }

    @Override
    public ProjetDetail findProjetDetailById(Long id) {
        return projetDetailRepository.findProjetDetailById(id);
    }

    @Override
    public List<ProjetDetail> findAllProjetDetails() {
        return projetDetailRepository.findAllProjetDetails();
    }
}
