package edu.iset4C.formationSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.iset4C.formationSpringBoot.entities.Utilisateur;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
public List<Utilisateur> findByFirstName(String firstName);
}
