package tn.esprit.tpprojet2025.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpprojet2025.Entities.Entreprise;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query("SELECT e FROM Entreprise e WHERE e.adresse = :adresse")
    List<Entreprise> findByadresseEntreprise(@Param("adresse") String adresse);
    @Query("SELECT entreprise FROM Entreprise entreprise join entreprise.equipes equipe where equipe.specialite =:specialite")
            List<Entreprise> retrieveEntreprisesBySpecialiteEquipe(@Param("specialite")String specialite);
    @Modifying
    @Transactional
    @Query("update Entreprise e set e.adresse = :adresse where e.idEntreprise =:idEntreprise")
            int updateEntrepriseByAdresse(@Param("adresse") String adresse,@Param("idEntreprise") Long idEntreprise);
    @Modifying
    @Transactional
    @Query("DELETE FROM Entreprise e WHERE e.adresse= ?1")
    int deleteEntrepriseByAdresse(String adresse);
}
