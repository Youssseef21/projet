package tn.esprit.tpprojet2025.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet2025.Entities.Equipe;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT equipe FROM Equipe equipe"
            + " JOIN equipe.projets projet"
            + " where projet.projetDetail.dateDebut > current_date"
            + " and projet.projetDetail.technologie =:technologie")
    List<Equipe> retrieveEquipesByProjetTechnologie(@Param("technologie")
                                                    String technologie);
}
