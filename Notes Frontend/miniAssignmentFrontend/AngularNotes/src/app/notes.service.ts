import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Notes } from './notes';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class NotesService {
  [x: string]: any;

   private baseURL="http://localhost:9090/addnotes";
  constructor(private http:HttpClient) { }
  getNotesList(email:String): Observable<Notes[]>{
    return this.http.get<Notes[]>(`http://localhost:9090/notes/${email}`);
  }

  addNotes(notes:Notes):Observable<Object>{
    return this.http.post(`${this.baseURL}`,notes);
  }
  // updateNotes(id:number,notes:Notes): Observable<Object>{
  //   return  this.http.put(`http://localhost:9090/update/${id}`, notes)}

  // }
  deleteNote(id: number):Observable<Object>{
    return this.http.delete(`http://localhost:9090/notes/${id}`);
  }

  saveCred(user:User):Observable<Object>{
    return this.http.post(`http://localhost:9090/saveLogin`,user)
  }
  signin(user:User):Observable<Object>{
    return this.http.post(`http://localhost:9090/signin`,user)
  }

  saveOrUpdateUser(user:User):Observable<Object>{
    return this.http.post(`http://localhost:9090/check`,user)
  }

  //  getNoesByemail()


  private apiUrl:"http://localhost:9090/registeruser"
  registeruser(user: User) {
    console.log(user)
    return this.http.post(`http://localhost:9090/registeruser`, user);
  }

  
  
}
   

function getNotesList() {
  throw new Error('Function not implemented.');
}

