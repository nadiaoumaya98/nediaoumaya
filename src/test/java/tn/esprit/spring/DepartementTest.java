package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	
	@Autowired
	IEntrepriseService it;

		private static final Logger LOGGER = LogManager.getLogger(DepartementTest.class);

	
	@Test
	public void testAjouterDepartement()
	{
		
		Departement dep = new Departement( "Info");
		int c= it.ajouterDepartement(dep);
		assertThat(c).isGreaterThan(0);
		LOGGER.info("Added successfully with");
		Assert.assertTrue(c>0);
}
	@Test
	public void testListDep() {
		List<String> e=it.getAllDepartementsNamesByEntreprise(2);
		int n=e.size();
	assertThat(n>0);
	}
}
