package edu.iset4C.formationSpringBoot.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.iset4C.formationSpringBoot.entities.Utilisateur;
import edu.iset4C.formationSpringBoot.requests.FirstNameAndLastNameRequest;
import edu.iset4C.formationSpringBoot.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class Utilisateurcontroller {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@GetMapping()
	public List<Utilisateur> getAllUtilisateur() {
		return utilisateurService.getAllUtilisateurs();
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Utilisateur>  findUtilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
		if (utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
		}
		
	}
	
	/*@GetMapping(path = "/findByIdWithRequestParam")//http://localhost:8080/utilisateur/findByIdWithRequestParam?id=1
	public ResponseEntity<Utilisateur>  findUtilisateurById(@RequestParam Long id) {
		Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
		if (utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
		}
		
	}*/
/*	@GetMapping(path = "/findByFirstNameAndLastName/{firstName}/{lastName}")//http://localhost:8080/utilisateur/findByFirstNameAndLastName/{firstName}/{lastName}
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName) {
	    List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameAndLastName(firstName,lastName);
	    if (utilisateurs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        for (Utilisateur user : utilisateurs){
	            System.out.println(user);
	        }
	        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	    }
	}     */
	@GetMapping(path = "/findByFirstNameAndLastNameWithRB")
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstNameAndLastName(
		@RequestBody	FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
	    List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameAndLastNameWithJPQLWithNamedParameters(firstNameAndLastNameRequest.getFirstName(),firstNameAndLastNameRequest.getLastName());
	    if (utilisateurs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        for (Utilisateur user : utilisateurs){
	            System.out.println(user);
	        }
	        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	    }
	} 
	@GetMapping(path = "/findByFirstName/{firstName}")
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstName(@PathVariable String firstName) {
	    List<Utilisateur> utilisateurs = utilisateurService.findByFirstName(firstName);
	    if (utilisateurs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        for (Utilisateur user : utilisateurs){
	            System.out.println(user);
	        }
	        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	    }
	}
	
	@GetMapping(path = "/findByAge")
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByAge(@RequestBody List<Integer> ages) {
	    List<Utilisateur> utilisateurs = utilisateurService.findByAgeIn(ages);
	    if (utilisateurs.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        for (Utilisateur user : utilisateurs){
	            System.out.println(user);
	        }
	        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	    }
	}
	
	@PostMapping
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.createUtilisateur(utilisateur);
	}
	
	@PutMapping
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUtilisateur(utilisateur);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteAllUtilisateur(@PathVariable Long id) {
		 utilisateurService.deleteUtilisateur(id);
		 System.out.println("utilisateur was deleted");
	}

}
