package mishra.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mishra.Exception.DuplicateEntryException;
import mishra.model.Loginpage;
import mishra.model.Notes;
import mishra.repository.LoginpageRepository;
import mishra.service.RegistrationService;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	
	
	private RegistrationService service;
	
	
	
	@Autowired
	private LoginpageRepository loginRepository;
	
//	@GetMapping("/message")public ResponseEntity<String> getMessage() { 
//		String message = "Hello, World!"; 
//		return ResponseEntity.ok(message);     }
	
	@PostMapping("/signin")
	public Loginpage SignInUser(@RequestBody Loginpage login)  {
		String username=login.getUsername();
		String password=login.getPassword();
		
			Loginpage user=loginRepository.findByUsername(username);
			String userPassword="";
			if(user != null) {
				userPassword=user.getPassword();
			}
		if(password.equals(userPassword)) {
			 login.isValid=true;	
		}
		else {
			 login.isValid=false;
		}
		return login;

		
	}
	
	
	@PostMapping("/registeruser")
	public void  registeruser(@RequestBody Loginpage login) throws Exception {
//		loginRepository.save(login);
		 if (loginRepository.existsByUsername(login.getUsername())) {
			    throw new DuplicateEntryException("user already exists");
			  }
			  loginRepository.save(login);
			}

	}
	// Check for duplicate email in your service or repository
	
//	@PostMapping("/check")
//	public void saveOrUpdateUser(Loginpage login)throws Exception {
//	  if (loginRepository.existsByUsername(login.getUsername())) {
//	    throw new DuplicateEntryException("user already exists");
//	  }
//	  loginRepository.save(login);
//	}


