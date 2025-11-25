package tn.esprit.tpprojet2025.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet2025.Entities.Projet;
import tn.esprit.tpprojet2025.Entities.ProjetDetail;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT projet FROM Projet projet where "+"projet.projetDetail.technologie =:technologie "+"and projet.projetDetail.Cout >:cout")
    List<Projet> retrieveProjetsByCoutAndTechnologie(@Param("technologie") String technologie, @Param("cout") Long cout);
    
}
