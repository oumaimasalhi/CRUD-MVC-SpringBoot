package com.CRUD.Project.Controllers;

//import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static com.CRUD.Project.CrudApplication.Classes ;


import com.CRUD.Project.entities.Classe;



@Controller
@RequestMapping("/fst")

public class ClassControllers {
	@GetMapping("/education") 

	public String inf(Model model) {
		
		
		model.addAttribute("Classes",Classes);
		
		return "classe/classe.html"; 
	  }


	
	//Ajout
	@GetMapping ("/nouvelClass") 
	public String addclass() {
		
		return "classe/nouvelClass";
		
	}


	@PostMapping("/nouvelClass") 
	public String addClass ( @RequestParam("id") int id, @RequestParam("nom") String nom ) 
	{
			
		Classe c4= new Classe (id, nom); 
	  Classes.add(c4); 
		return "redirect:/fst/education"; 
		
		
		} 




    //supprimer
	@GetMapping ("delete/{id}" )
	public String deletClass(@PathVariable("id") int id ) 
	{
		
		for(Classe c:Classes) 
		{
		if (c.getId()==id)
		{
			Classes.remove(c);
		           break;
		}
		
	    
	   }
	return "redirect:../education";
	}


	//Modifer
		@GetMapping("/edit/{id}")
		public String editClass(@PathVariable("id") int id ,Model model ) {
	        
			for(Classe c:Classes) 
	        {
			if (c.getId()==id)
			 {
				
			     model.addAttribute("c", c);
	         }
			}
			
			return "classe/modifierClasse";
			
		
		}
		
		
		@PostMapping("/update")
		//ResponseBody
		public String modifier(Classe Classe){
			
			for(Classe c:Classes)  {
			
			if (c.getId()== Classe.getId())
			{
				Classes.set(Classes.indexOf(c), Classe);
			}
		}   
		
		return "redirect:education";
		    
		
		}
}		




