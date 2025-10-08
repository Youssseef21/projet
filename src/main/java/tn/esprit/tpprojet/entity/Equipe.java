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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    
    @Enumerated(EnumType.STRING)
    private Domaine domaine;
    
    @ManyToMany(mappedBy = "equipes", cascade = CascadeType.ALL)
    Set<Projet> projets;
    
    @ManyToOne
    Entreprise entreprise;
}
