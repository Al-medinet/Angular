package org.musql;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.musql.dao.EtudiantRepository;
import org.musql.entities.Etudiants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EtudiantSecurityApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext applicationContext=SpringApplication.run(EtudiantSecurityApplication.class, args);
		EtudiantRepository etudiant = applicationContext.getBean(EtudiantRepository.class);
		/*DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		etudiant.save(new Etudiants("Jemhour","Mehdi",df.parse("1993-08-24")));
		etudiant.save(new Etudiants("Aradi","El Mehdi",df.parse("1996-10-14")));
		etudiant.save(new Etudiants("Sirajy","Othmane",df.parse("1992-01-11")));
		etudiant.save(new Etudiants("Yazidi","Abdelhadi",df.parse("1993-05-20")));
		etudiant.save(new Etudiants("Rachidi","Chems-Eddine",df.parse("1996-04-10")));*/
		
		List<Etudiants> list=etudiant.findAll();
		for(Etudiants etud:list)
		{
			System.out.println("Nom : "+etud.getNom()+" Prenom : "+etud.getPrenom());
		}
	}
}
