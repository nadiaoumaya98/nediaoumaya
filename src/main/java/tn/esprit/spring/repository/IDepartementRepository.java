package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Departement;

@Repository
public interface IDepartementRepository  extends CrudRepository<Departement,Long>{
	
	@Query("SELECT d.nameDepartement FROM Departement d where Entreprise.idEntreprise = : idEntreprise")
	List<String> getAllDepartementsNamesByEntreprise(int idEntreprise);
    
    @Query("Select "
			+ "DISTINCT AVG(cont.salaire) from Contrat cont "
			+ "join cont.Employe e "
			+ "join e.Departement dep "
			+ "where dep.id=:depId")
    public Double getSalaireMoyenByDepartementId(@Param("depId")long departementId);

}
