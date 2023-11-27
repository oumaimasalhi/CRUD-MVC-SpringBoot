package com.CRUD.Project;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.CRUD.Project.entities.Etudiant;
import com.CRUD.Project.entities.Classe;


@SpringBootApplication
public class CrudApplication {
	
	public static List<Etudiant> Etudiants=new ArrayList <>();
	public static  List<Classe> Classes = new ArrayList<>(); 

	public static void main(String[] args) {
		
		    Etudiant E1=new Etudiant (1,"oumaima","salhi","oumaima@gmail.com","tunis");
		    Etudiant E2=new Etudiant (2,"farida","hamdi","farida@gmail.com","kef");
		    Etudiant E3=new Etudiant (3,"hamza","wertani","hamza@gmail.com","beja");
		   
		    Etudiants.add(E1);
		    Etudiants.add(E2);
		    Etudiants.add(E3);
		    
		    
		    
		    
		   Classe c1 = new Classe(1,"gestion") ;
			Classe c2 = new Classe(2, "info");
		    Classe c3 = new Classe (3, "droit");
			
			Classes.add (c1);
			Classes.add (c2);
			Classes.add (c3);
		
		SpringApplication.run(CrudApplication.class, args);
	}

}

