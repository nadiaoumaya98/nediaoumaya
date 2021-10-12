package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "T_EMPLOYE")
public class Employe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idEmploye;
	
	@Column(name="NOM")
	private String nomEmploye;
	
	@Column(name="PRENOM")
	private String prenomEmploye;
	
	@Column(name="EMAIL")
	private String emailEmploye;
	
	private boolean isActif;
	
	@Enumerated (EnumType.STRING)
	@Column(name="ROLE")
	private Role roleEmploye;
	
	
	@OneToOne
	private Contrat Contrat; 
	
	@OneToMany (mappedBy="Employe", cascade = CascadeType.ALL)
	private Set<Timesheet> Timesheet;
	
	@ManyToMany(mappedBy="Employe", cascade = CascadeType.ALL)
	private Set<Departement> Departement;

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRoleEmploye() {
		return roleEmploye;
	}

	public void setRoleEmploye(Role roleEmploye) {
		this.roleEmploye = roleEmploye;
	}

	public Contrat getContrat() {
		return Contrat;
	}

	public void setContrat(Contrat contrat) {
		Contrat = contrat;
	}


	public Set<Departement> getDepartement() {
		return Departement;
	}

	public void setDepartement(Set<Departement> departement) {
		this.Departement = departement;
	}

	public Employe() {
		super();
	}

	public Set<Timesheet> getTimesheet() {
		return Timesheet;
	}

	public void setTimesheet(Set<Timesheet> timesheet) {
		Timesheet = timesheet;
	}

	public Employe(Long idEmploye, String nomEmploye, String prenomEmploye, String emailEmploye, boolean isActif,
			Role roleEmploye, Contrat contrat, Set<Timesheet> timesheet,
			Set<Departement> departement) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.emailEmploye = emailEmploye;
		this.isActif = isActif;
		this.roleEmploye = roleEmploye;
		Contrat = contrat;
		Timesheet = timesheet;
		Departement = departement;
	}
}
