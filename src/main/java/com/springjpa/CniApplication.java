package com.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cni.security.BCrypt;
import com.springjpa.model.Customer;
import com.springjpa.model.Famille;
import com.springjpa.model.Role;
import com.springjpa.model.SousFamille;
import com.springjpa.model.SousStructure;
import com.springjpa.model.Structure;
import com.springjpa.repo.CustomerRepository;
import com.springjpa.repo.FamilleRepository;
import com.springjpa.repo.RoleRepository;
import com.springjpa.repo.SousFamilleRepository;
import com.springjpa.repo.SousStructure_Repository;
import com.springjpa.repo.StructureRepository;

@SpringBootApplication
public class CniApplication {
	@Autowired
    private static RoleRepository RR;
	
	private static String secretKey = "isverysecret";
	public static void main(String[] args) {
		
		System.setProperty("server.port", "8081");
		
		SpringApplication.run(CniApplication.class, args);
		
		
	}
	
	@Bean
    public CommandLineRunner InsertROLES(RoleRepository repo) {
        return args -> { 
            repo.save(new Role(1,"SuperAdministrateur"));
            repo.save(new Role(2,"Administrateur"));
            repo.save(new Role(3,"Responsable Magasin"));
            repo.save(new Role(4,"Agent Magasin"));
            repo.save(new Role(5,"Responsable Fournisseur"));
            repo.save(new Role(6,"Agent Fournisseur"));
        };
    }
	@Bean
    public CommandLineRunner InsertCNI(StructureRepository repo) {
        return args -> { 
            repo.save(new Structure("CodeCNI","CNI","CNI"));
        };
    }
	@Bean
    public CommandLineRunner InsertSousCNI(SousStructure_Repository repo) {
		Structure CNI=new Structure("CodeCNI","CNI","CNI");
        return args -> { 
            repo.save(new SousStructure("CodeSousCNI",CNI));
        };
    }
	
	@Bean
    public CommandLineRunner InsertFamille(FamilleRepository repo) {
        return args -> { 
            repo.save(new Famille(1,"BIC"));
            repo.save(new Famille(2,"APPLE"));
            repo.save(new Famille(3,"ASUS"));
            repo.save(new Famille(4,"MSI"));
            repo.save(new Famille(5,"ACER"));
            repo.save(new Famille(6,"Samsung"));
            repo.save(new Famille(7,"HP"));
        };
    }
	
	@Bean
    public CommandLineRunner InsertSousFamille(SousFamilleRepository repo) {
        return args -> { 
        	repo.save(new SousFamille(1,"Ordinateur"));
            repo.save(new SousFamille(2,"Souris"));
            repo.save(new SousFamille(3,"Clavier"));
            repo.save(new SousFamille(4,"Tapis"));
            repo.save(new SousFamille(5,"Micro Casques"));
            repo.save(new SousFamille(6,"Ecran"));
            repo.save(new SousFamille(7,"Webcam"));
            repo.save(new SousFamille(8,"Imprimante"));
            repo.save(new SousFamille(9,"Disque dur"));
            repo.save(new SousFamille(10,"Clé USB"));
            
        };
    }
	
	@Bean
    public CommandLineRunner InsertSuperAdmin(CustomerRepository repo) {
		if(repo.count()==0) {
		String Securepw=BCrypt.encrypt("Fedi", secretKey);
		Role SuperAdminCNI= new Role(1,"SuperAdministrateur");
		Structure StructureCNI=new Structure("CodeCNI","CNI","CNI");
        return args -> { 
            repo.save(new Customer(1,"Fedi","Abdelkebir","fedi.abdelkebir@yahoo.fr",Securepw,58205523,SuperAdminCNI,StructureCNI));
            
        };
		}else {
			return args -> { };
		}       
    }
}
