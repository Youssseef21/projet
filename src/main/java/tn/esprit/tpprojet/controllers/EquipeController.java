package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Fallback;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entity.Equipe;
import tn.esprit.tpprojet.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipes")
@AllArgsConstructor
public class EquipeController {
    final IEquipeService equipeService;
    @PostMapping("/add-equipe")
    void addEquipe(@RequestBody Equipe E){
        equipeService.addOrUpdateEquipe(E);
    }
    @PutMapping("/update-equipe")
    void updateEquipe(@RequestBody Equipe E){
        equipeService.addOrUpdateEquipe(E);}

    @DeleteMapping("/delete-equipe/{id}")
    void deleteEquipe(@PathVariable("id") Long id){
        equipeService.deleteEquipe(id);}

    @GetMapping("/get-all-equipes")
    List<Equipe> getAllEquipes(){
        return equipeService.findAllEquipes();}

    @GetMapping("/get-equipe-by-id/{id}")
    Equipe getEquipeById(@PathVariable("id") Long id){
        return equipeService.findEquipeById(id);}

}
