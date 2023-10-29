package edu.iset4C.formationSpringBoot.service;

import java.util.List;


import edu.iset4C.formationSpringBoot.entities.Utilisateur;

public interface UtilisateurService {
	
	// crud basic
public List<Utilisateur> getAllUtilisateurs();
public Utilisateur findUtilisateurById(Long id) ;
public Utilisateur createUtilisateur(Utilisateur utilisateur) ;
public Utilisateur updateUtilisateur(Utilisateur utilisateur);
void deleteUtilisateur(Long id);
//methode avancee 
public List<Utilisateur> findByFirstName(String firstName) ;
public List<Utilisateur> findByFirstNameAndLastNameWithJPQLWithNamedParameters(String firstName,String lastName) ;

public List <Utilisateur> findByAgeIn(List<Integer> ages);
public List<Utilisateur> findByRolesTitre(String titre);
public List< Utilisateur> findByRolesTitreAndAdressesVille(String titre,String ville);

/*public List<Utilisateur> findByRolesTitreAndAdresseVille(String titre,String ville);*/





}
