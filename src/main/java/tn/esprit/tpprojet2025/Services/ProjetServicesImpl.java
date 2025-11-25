package tn.esprit.tpprojet2025.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet2025.Entities.Equipe;
import tn.esprit.tpprojet2025.Entities.Projet;
import tn.esprit.tpprojet2025.Entities.ProjetDetail;
import tn.esprit.tpprojet2025.Repositories.EquipeRepository;
import tn.esprit.tpprojet2025.Repositories.ProjetDetailRepository;
import tn.esprit.tpprojet2025.Repositories.ProjetRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class ProjetServicesImpl implements IProjetServices{


    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ProjetDetailRepository projetDetailRepository;

    @Autowired
    private EquipeRepository equipeRepository;


    @Override
    public Projet AjouterProjet(Projet projet) {
        return  projetRepository.save(projet);
    }
    //@Scheduled(fixedDelay = 10000)
    //@Scheduled(fixedRate = 60000, initialDelay = 10000,timeUnit= TimeUnit.SECONDS)
//    @Scheduled(cron = "0 15 8 * * MON")
//    @Scheduled(cron = "*/15 * 8-12 * * MON-FRI")
//
//    @Scheduled(cron = "0 */10 9-17 * * MON-FRI")
//
//    @Scheduled(cron = "0 15 8 * * MON")

    @Override
    public List<Projet> afficherListeProjets() {
        List<Projet> projects = projetRepository.findAll();
        for (Projet projet : projects) {
            log.info("Projet ID: {}, Nom: {}", projet.getIdProjet(), projet.getNomProjet());
        }
                return projects;
    }

    @Override
    public Projet afficherProjetSelonID(long idProjet) {
        return projetRepository.findById(idProjet).get();
    }

    @Override
    public Projet modifierProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void supprimerProjet(long idProjet) {
         projetRepository.deleteById(idProjet);
    }

    @Override
    public void assignProjetDetailToProjet(long idProjet, long idProjetDetail) {
        Projet projet = projetRepository.findById(idProjet).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(idProjetDetail).get();
        // Affecter ProjetDetail (Fils) au Projet (Père)
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    @Override
    public void assignProjetToEquipe(long idProjet, long idEquipe) {
        Projet projet = projetRepository.findById(idProjet).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        //Affecter Projet (Fils) à Equipe (Père)
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    @Override
    public Projet addProjetAndAssignProjetDetailToProjet(long idProjetDetail, Projet projet) {
        ProjetDetail projetDetail = projetDetailRepository.findById(idProjetDetail).get();
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    @Override
    public void UnassignProjetDetailFromProjet(long idProjet) {
        Projet projet = projetRepository.findById(idProjet).get();
        projet.setProjetDetail(null);
        projetRepository.save(projet);
    }

    @Override
    public void UnassignProjetFromEquipe(long idEquipe, long idProjet) {
      Equipe equipe = equipeRepository.findById(idEquipe).get();
      Projet projet = projetRepository.findById(idProjet).get();
      equipe.getProjets().remove(projet);
      equipeRepository.save(equipe);
    }
    @Override
    public List<Projet> retrieveProjetsByCoutAndTechnologie(String technologie, Long cout) {
        return projetRepository.retrieveProjetsByCoutAndTechnologie(technologie, cout);
    }

}
