import { Component ,OnInit} from '@angular/core';
import { Notes } from '../notes';
import { NotesService } from '../notes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-notes',
  templateUrl: './create-notes.component.html',
  styleUrls: ['./create-notes.component.css']
})
export class CreateNotesComponent implements OnInit {
   
  notes:Notes=new Notes();
  constructor(private notesservice:NotesService,
    private router:Router) {}

  ngOnInit(): void {
      
  }
  saveNotes(){
    this.notesservice.addNotes(this.notes).subscribe(data => {
      console.log(data);
      this.goToNotesList();
    });
  }

  goToNotesList(){
    this.router.navigate(['/newnotes'])

  }
  onSubmit(){
    console.log(this.notes)
    this.saveNotes();
  }
}
