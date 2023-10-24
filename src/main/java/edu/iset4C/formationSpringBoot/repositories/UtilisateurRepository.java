package edu.iset4C.formationSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.iset4C.formationSpringBoot.entities.Utilisateur;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
public List<Utilisateur> findByFirstName(String firstName);
public List<Utilisateur> findByFirstNameAndLastName(String firstName,String lastName);


@Query("SELECT u FROM Utilisateur u WHERE u.firstName= ?1 AND u.lastName= ?2")
public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName,String lastName);

@Query("SELECT u FROM Utilisateur u WHERE u.firstName LIKE :myFirstName OR u.lastName LIKE :myLastName")
public List<Utilisateur> findByFirstNameAndLastNameWithJPQLWithNamedParameters(@Param(value = "myFirstName") String firstName, @Param(value = "myLastName") String lastName);

public List< Utilisateur> findByAgeIn(List <Integer> ages);
/*
 * comparisons are case-insensitive
 * @Query("SELECT u FROM Utilisateur u WHERE BINARY u.firstName= ?1 AND BINARY u.lastName= ?2")
public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String lastName);*/

}
