package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entity.Projet;
import tn.esprit.tpprojet.services.IProjetService;

@RestController
@RequestMapping("/projetController")
@AllArgsConstructor
public class ProjetController {

    final IProjetService projetService;
    @PostMapping("/add-projet")
    Projet addProjet(@RequestBody Projet p){
        return projetService.addOrUpdateProjet(p);
    }
    @PutMapping("/update-projet")
    Projet updateProjet(@RequestBody Projet p){
        return projetService.addOrUpdateProjet(p);

}
    @DeleteMapping("/delete-projet/{id}")
    void deleteProjet(@PathVariable("id") Long id){
        projetService.deleteProjet(id);
    }
    @GetMapping("/getallprojets")
    java.util.List<Projet> getAllProjets(){
        return projetService.findAllProjets();
    }
    @GetMapping("/get-projet-by-id/{id}")
    Projet getProjetById(@PathVariable("id") Long id){
        return projetService.findProjetById(id);
    }
}
