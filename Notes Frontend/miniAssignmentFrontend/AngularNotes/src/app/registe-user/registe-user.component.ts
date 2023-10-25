import { Component,OnInit } from '@angular/core';
import { User } from '../user';
import { NotesService } from '../notes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registe-user',
  templateUrl: './registe-user.component.html',
  styleUrls: ['./registe-user.component.css']
})
export class RegisteUserComponent {
  user = {
    username: '',
    password: ''
  };

  constructor(private notesService: NotesService,
    private router:Router) {}
    goToNotesList(){
        this.router.navigate(['/Login'])
    
      }
      isSuccess=false;
      ifFormSubmitted=false;
  onSubmit() {
    this.ifFormSubmitted= true ;
    this.notesService.registeruser(this.user).subscribe(
      (response) => {
        // Handle the response from the server
        console.log('User registration successful:', response);
        this.goToNotesList();
        this.isSuccess=true;

      },
      (error) => {
        // Handle any errors that occur during the request
        console.error('Error registering user:', error);
        this.isSuccess=false;

      }
    );
  }
}

  

  
  // user:User=new User();
  // constructor(private notesservice:NotesService,
  //   private router:Router) {}

  // ngOnInit(): void {
      
  // }
  
  // onSubmit(){
  //  this.savedata();
  // }
  // onSubmit() {
  //   // Call the registerUser method from the service
  //   this.notesservice.registeruser(this.user).subscribe(
  //     (data) => {
  //       console.log(data);
  //       this.goToNotesList();
  //     },
  //     (error) => {
  //       // Handle error, if needed
  //       console.error(error);
  //     }
  //   );
  // }

  // savedata(){
  //   this.notesservice.registeruser(this.user).subscribe(data => {
  //     console.log(data);
  //     this.goToNotesList();
  //   })
  // }
  // goToNotesList(){
  //   this.router.navigate(['/Login'])

  // }
  
  // onSubmit(){
  //   console.log(this.user);

  // }

