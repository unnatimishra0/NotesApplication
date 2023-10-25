import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MynotesComponent } from './mynotes/mynotes.component';
import { CreateNotesComponent } from './create-notes/create-notes.component';
import { GetnotesComponent } from './getnotes/getnotes.component';
import { UpdateNotesComponent } from './update-notes/update-notes.component';
import { LoginNotesComponent } from './login-notes/login-notes.component';
import { RouteNotesComponent } from './route-notes/route-notes.component';
import { RegisteUserComponent } from './registe-user/registe-user.component';

const routes: Routes = [
 
  {
    component:MynotesComponent,
    path:'newnotes'
  },
  {
    component:CreateNotesComponent,
    path:'createnotes'
  },
  {
    component:GetnotesComponent,
    path:'getnotes'
  },
  {
    component:UpdateNotesComponent,
    path:'update-notes/:id'
  },
  {
    component:LoginNotesComponent,
    path:"Login"
  },
  {
    component:RouteNotesComponent,
    path:"route"
  }, {
    component:RegisteUserComponent ,
    path:"register"
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
