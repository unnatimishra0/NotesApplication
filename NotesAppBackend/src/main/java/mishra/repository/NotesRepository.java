package mishra.repository;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mishra.model.Notes;
@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	List<Notes> findByemail(String email);

	List<Notes> findTop10ByOrderByCreatedAtDesc();
	
	@Transactional
    @Modifying
    @Query(value = "DELETE n1 FROM notes AS n1 LEFT JOIN ( SELECT id AS note_id FROM notes WHERE email = %:email% ORDER BY createdAt DESC LIMIT 10 ) AS n2 ON n1.id = n2.note_id WHERE note_id IS NULL AND email= %:email%",nativeQuery = true)
    void deleteUsers(@Param("email")String email);

//	Page<Notes> getAllNotes(Pageable pageable);
	
	

}
