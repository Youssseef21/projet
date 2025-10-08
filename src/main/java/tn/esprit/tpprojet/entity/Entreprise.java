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
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEntreprise;
    private String nom;
    private String adresse;
    
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    Set<Equipe> equipes;
}
