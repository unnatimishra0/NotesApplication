package mishra.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mishra.Exception.DuplicateEntryException;
import mishra.model.Loginpage;
import mishra.repository.LoginpageRepository;

public class RegistrationService {
	
	@Autowired
	private LoginpageRepository loginRepository;
	
	@PostMapping("/saveLogin")
	public Loginpage saveCred(@RequestBody Loginpage login) {
		return loginRepository.save(login);
	}
    
	public Loginpage fetchByUsername(String username) {
		 return loginRepository.findByUsername(username);
	
	}
	// Check for duplicate email in your service or repository
	@PostMapping("/check")
	public void saveOrUpdateUser(Loginpage login)throws Exception {
	  if (loginRepository.existsById(login.getId())) {
	    throw new DuplicateEntryException("Id already exists");
	  }
	  loginRepository.save(login);
	}

}
