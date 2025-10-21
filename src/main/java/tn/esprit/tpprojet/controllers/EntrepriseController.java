package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entity.Entreprise;
import tn.esprit.tpprojet.entity.Equipe;
import tn.esprit.tpprojet.services.IEntrepriseService;

import java.util.List;

@RestController
@RequestMapping("/entrepriseController")
@AllArgsConstructor
public class EntrepriseController {
    final IEntrepriseService entrepriseService;
    @PostMapping("/add-entreprise")
    void addEntreprise(@RequestBody Entreprise E){
        entrepriseService.addOrUpdateEntreprise(E);
    }
    @PutMapping("/update-entreprise")
    void updateEntreprise(@RequestBody Entreprise E){
        entrepriseService.addOrUpdateEntreprise(E);}
    @DeleteMapping("/delete-entreprise/{id}")
    void deleteEntreprise(@PathVariable("id") Long id){
        entrepriseService.deleteEntreprise(id);}
    @GetMapping("/get-all-entreprises")
    List<Entreprise> getAllEntreprises(){
        return entrepriseService.findAllEntreprises();}
    @GetMapping("/get-entreprise-by-id/{id}")
    Entreprise getEntrepriseById(@PathVariable("id") Long id){
        return entrepriseService.findEntrepriseById(id);}
}
