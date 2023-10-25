import { Component ,OnInit} from '@angular/core';
import{Notes} from "../notes";
import { NotesService } from '../notes.service';
import { Router } from '@angular/router';
import { EmailService } from '../email.service';

@Component({
  selector: 'app-mynotes',
  templateUrl: './mynotes.component.html',
  styleUrls: ['./mynotes.component.css']
})
export class MynotesComponent implements OnInit {
  notes: Notes[];

  constructor(private notesService:NotesService,
    private router:Router,
    private emailService: EmailService){ }

  ngOnInit(): void {
    this.getNotes();
 
      
    }
    private getNotes(){
      this.notesService.getNotesList(this.emailService.getEmail()).subscribe(data =>
        this.notes = data)
    }
    updateNotes(id:number){
      this.router.navigate(["update-notes",id])
    }
    deleteNotes(id:number){
      this.notesService.deleteNote(id).subscribe(data =>{
        console.log(data);
        this.getNotes();
      })
    }
}
