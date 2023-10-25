package mishra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mishra.model.Loginpage;


public interface LoginpageRepository extends JpaRepository<Loginpage,Integer>{
	
//	public  Loginpage getById(int id);

	
	Loginpage findByUsername(String username);

	boolean existsByUsername(String username);
	
	

	
}
