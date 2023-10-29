package edu.iset4C.formationSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.iset4C.formationSpringBoot.entities.Utilisateur;
import edu.iset4C.formationSpringBoot.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	
	@Autowired 
	private UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		 return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		 Optional<Utilisateur> utOptional = utilisateurRepository.findById(id);
		if (utOptional.isEmpty()) {
			System.out.println("this user is not exist");
			return null;
		}else {
			return utOptional.get();
		}
		
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		 Optional<Utilisateur> utOptional = utilisateurRepository.findById(utilisateur.getId());
		 if (utOptional.isEmpty()) {
			 System.out.println("this user is not exist");
				return null;
			}else {
				System.out.println("utilisateur was updated");
				return utilisateurRepository.save(utilisateur);
			}
		
	}

	@Override
	public void deleteUtilisateur(Long id) {
		System.out.println("utilisateur was deleted");
		utilisateurRepository.deleteById(id);
	}

	@Override
	public List<Utilisateur> findByFirstName(String firstName) {
		return utilisateurRepository.findByFirstName(firstName);
		
	}
	
	@Override
	public List<Utilisateur> findByFirstNameAndLastNameWithJPQLWithNamedParameters(String firstName,String lastName){
		return utilisateurRepository.findByFirstNameAndLastName(firstName, lastName);
		
	}

	@Override
	public List<Utilisateur> findByAgeIn(List<Integer> ages) {
		return utilisateurRepository.findByAgeIn(ages);
	}

	@Override
	public List<Utilisateur> findByRolesTitre(String titre) {
		return utilisateurRepository.findByRolesTitre(titre);
	}
/*
	@Override
	public List<Utilisateur> findByRolesTitreAndAdresseVille(String titre, String ville) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	@Override
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByRolesTitreAndAdressesVille(titre, ville);
	}

	
	
}
