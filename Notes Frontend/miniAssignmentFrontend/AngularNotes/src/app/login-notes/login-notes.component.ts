import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { NotesService } from '../notes.service';
import { ToastrService } from 'ngx-toastr';
import { EmailService } from '../email.service';
import { Notes } from '../notes';


@Component({
  selector: 'app-login-notes',
  templateUrl: './login-notes.component.html',
  styleUrls: ['./login-notes.component.css']
})
export class LoginNotesComponent implements OnInit {

  userEmail: string = '';

  user:User=new User();
  userinput = {
    username: '',
    password: ''
  };
  notes:Notes=new Notes();
  constructor(private notesservice:NotesService,
    private router:Router,
    private toastr: ToastrService,
    private emailService: EmailService){
    

    }
    ngOnInit(): void {}

  // 
  //  onSubmit() {
  //   var data=this.notesservice.signin(this.user)
  //     console.log(data);
  //     if(data.toString()==='successful')
  //       this.goToNotesList();
  // }

  // onSubmit() {
  //   this.notesservice.signin(this.user).subscribe(data => {
  //     console.log(data);
  //     this.goToNotesList();
  //   });
  // }
  onSubmit() {
    this.notesservice.signin(this.user).subscribe((res: any) => {
        console.log(res);
      this.emailService.setEmail(this.user.username);
      console.log(this.emailService.getEmail());
      this.userinput.username = '';
      this.userinput.password = '';
      if (res.isValid) {
          this.toastr.success('User login successfully.', 'Authentication:')
        console.log(this.user);
        // this.user.reset();
        this.router.navigate(['/newnotes'])
      }
      else{
        this.toastr.error('Incorrect username or password.', 'Authentication:')

      }
    },
      err => {
          console.log(err)
      });
  }
}
  // goToNotesList(){
  //   this.router.navigate(['/newnotes'])

  // }
  

  // onSubmit(){
  //   this.saveCred();
  //   this.router.navigate(['/newnotes'])
  // }
  // public loginUser(user:User):Observable<any>{
    
  // }


