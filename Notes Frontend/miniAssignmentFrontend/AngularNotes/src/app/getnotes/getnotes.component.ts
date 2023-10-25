import { Component ,OnInit} from '@angular/core';
import { Notes } from '../notes';
import { NotesService } from '../notes.service';

@Component({
  selector: 'app-getnotes',
  templateUrl: './getnotes.component.html',
  styleUrls: ['./getnotes.component.css']
})
export class GetnotesComponent  {
  // notes: Notes[]=[];

  // constructor(private notesService:NotesService){ }

  // ngOnInit(): void {
  //   this.notesService.getNotesList().subscribe(data =>
  //     this.notes = data)
 
      
  //   }


}
