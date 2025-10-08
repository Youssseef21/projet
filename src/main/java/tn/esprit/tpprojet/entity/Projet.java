package tn.esprit.tpprojet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProjet;
    private String sujet;
    
    @OneToOne(mappedBy = "projet", cascade = CascadeType.ALL)
    ProjetDetail projetDetail;
    
    @ManyToMany
    Set<Equipe> equipes;
}
