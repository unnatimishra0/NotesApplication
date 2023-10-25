package mishra.controller;

import java.util.List;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mishra.Exception.ResourceNotFoundException;
import mishra.model.Loginpage;
import mishra.model.Notes;
import mishra.repository.LoginpageRepository;
import mishra.repository.NotesRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {
	
	@Autowired
	private NotesRepository notesRepository; 
	@Autowired
	private LoginpageRepository loginRepository;
	
	public  Loginpage getUser(int id) {
		return loginRepository.getById(id);
	}
//	@GetMapping("/user/id/{username}")
//	public int getUserId( @PathVariable String username) {
//		return loginRepository.getByUsername(username).getId();
//	}
	@PostMapping("/saveLogin")
	public Loginpage saveCred(@RequestBody Loginpage login) {
		return loginRepository.save(login);
	}

	//getAllnotes
	@GetMapping("/notes/{email}")
	public List<Notes> getAllNotes(@PathVariable String email){
		System.out.println(email);
		return notesRepository.findByemail(email);
	}
	@GetMapping("/registeruser")
	public  void User(){
		System.out.println("hiii");
	}
	// create notes rest api
	@PostMapping("/addnotes")
	public Notes createNotes(@RequestBody Notes notes) {
		return notesRepository.save(notes);
	}
	//get notes by email
	@GetMapping("/notes/email")
//	public ResponseEntity<Notes> getNotesByUsername(String username) {
//		System.out.println("hello");
//		Notes notes=notesRepository.findByUsername(username)
//		.orElseThrow(()-> new ResourceNotFoundException("notes not exist with email:"+email));
//		return ResponseEntity.ok(notes);
//	}
	//update notes
	@PutMapping("/notes/{id}")
	public ResponseEntity<Notes> updateNotes(Long id, @RequestBody Notes notesDetails){
		Notes notes=notesRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("notes not exist with id:"+id));
		
		notes.setTitle(notesDetails.getTitle());
		notes.setCategories(notesDetails.getCategories());
		notes.setContent(notesDetails.getContent());
		
		Notes updatedNotes=notesRepository.save(notes);
		return ResponseEntity.ok(updatedNotes);	
	}
	//delete notes
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNotes(@PathVariable Long id){
		Notes notes = notesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Notes not exist with id :" + id));
		
		notesRepository.delete(notes);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@Scheduled(fixedRate = 3000)
	public void deleteNotes() {
//		List<Loginpage> users= loginRepository.findAll();
//	    for (Loginpage user: users){
//	        notesRepository.deleteUsers(user.getUsername());
//	    }
//		List<Notes> recentRecords = notesRepository.findTop10ByOrderByCreatedAtDesc();
////		System.out.println(recentRecords);
//		if (recentRecords.size() > 5) {
//			List<Notes> recordsToDelete = recentRecords.subList(5, recentRecords.size());
//			notesRepository.deleteAll(recordsToDelete);
		}
		

 

	}
//	@GetMapping("/notes")
//	public ResponseEntity<Page<Notes>> getNotes(
//	    @RequestParam(defaultValue = "0") int page,
//	    @RequestParam(defaultValue = "10") int size
//	) {
//	    Pageable pageable = PageRequest.of(page, size);
//	    Page<Notes> notes = notesRepository.getAllNotes(pageable);
//	    return ResponseEntity.ok(notes);
//	}

	

