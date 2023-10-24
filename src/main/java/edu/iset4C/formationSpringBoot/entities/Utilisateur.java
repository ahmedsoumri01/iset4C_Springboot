package edu.iset4C.formationSpringBoot.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Utilisateur implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String firstName;
private String lastName;
private String email;
private String password;
private Date starterDate;
private int age;
private Boolean active;

@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
private Contact contact;

@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
private Set<Role> roles;

@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
private Set<Adresse> adresses;

public Set<Adresse> getAdresses() {
	return adresses;
}
public void setAdresses(Set<Adresse> adresses) {
	this.adresses = adresses;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public Contact getContact() {
	return contact;
}
public void setContact(Contact contact) {
	this.contact = contact;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getStarterDate() {
	return starterDate;
}
public void setStarterDate(Date starterDate) {
	this.starterDate = starterDate;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}

}
