package com.CRUD.Project.Controllers;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
//import org.springframework.web.bind.annotation.ResponseBody; 

import static com.CRUD.Project.CrudApplication.Etudiants;
import com.CRUD.Project.entities.Etudiant;





@Controller
@RequestMapping("/student")
public class EtudiantController {

@GetMapping("/education") 
	
	public String information(Model model) { 
	
		
		model.addAttribute("Etudiants", Etudiants); 
		
		 return "Etudiant/etudiant.html"; 
		
	}
	
	
	
	//Ajouter
	@GetMapping("/new") 
	public String createStudentForm() {
	        return "Etudiant/new.html";
	    }
	
	
	@PostMapping("/new") 
	public String addStudient ( @RequestParam("id") int id,
			@RequestParam("nom") String nom, 
			@RequestParam("prenom") String prenom, 
			@RequestParam("adresse") String adresse, 
			@RequestParam("email") String email)
	{ 
		Etudiant E4 = new Etudiant(id, nom, prenom, adresse, email); 
		Etudiants.add(E4); 
		return "redirect:/student/education"; 
		} 
	
	
	
	//supprimer
	@GetMapping ("delete/{id}")
	public String supprimer (@PathVariable ("id") int id )
	{

		for(Etudiant s:Etudiants) 
		{
		if (s.getId()==id)
		{
			Etudiants.remove(s);
		           break;
		}
		}
		
	      return "redirect:../education";	
	}
	
	 
	//Modifer
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id ,Model model ) {
        
		for(Etudiant s:Etudiants) 
        {
		if (s.getId()==id)
		 {
			
		     model.addAttribute("s", s);
         }
		}
		
		return "Etudiant/modifierEtudiant";
		
	
	}
	@PostMapping("/update")
	//ResponseBody
	public String modifier(Etudiant Etudiant){
		
	for(Etudiant s:Etudiants) {
		
		if (s.getId()== Etudiant.getId())
		{
            Etudiants.set(Etudiants.indexOf(s), Etudiant);
		}
	}   
	
	return "redirect:education";
	    
	}

  
  



	
	
	}

