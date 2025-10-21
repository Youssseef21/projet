package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entity.ProjetDetail;

import java.util.List;

public interface IProjetdetailService {
    ProjetDetail addOrUpdateProjetDetail(ProjetDetail pd);
    void deleteProjetDetail(Long id);
    ProjetDetail findProjetDetailById(Long id);
    List<ProjetDetail> findAllProjetDetails();
}
