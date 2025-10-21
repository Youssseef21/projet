package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entity.ProjetDetail;
import tn.esprit.tpprojet.services.IProjetdetailService;

@RestController
@RequestMapping("/projetDetailController")
@AllArgsConstructor
public class ProjetDetailController {
    final IProjetdetailService projetDetailService;
    @PostMapping("/add-projetDetail")
    void addProjetDetail(@RequestBody ProjetDetail E){
        projetDetailService.addOrUpdateProjetDetail(E);
    }
    @PutMapping("/update-projetDetail")
    void updateProjetDetail(@RequestBody ProjetDetail E){
        projetDetailService.addOrUpdateProjetDetail(E);}
    @DeleteMapping("/delete-projetDetail/{id}")
    void deleteProjetDetail(@PathVariable("id") Long id){
        projetDetailService.deleteProjetDetail(id);}
    @GetMapping("/get-projetDetail-by-id/{id}")
    ProjetDetail getProjetDetailById(@PathVariable("id") Long id){
        return projetDetailService.findProjetDetailById(id);}


}
