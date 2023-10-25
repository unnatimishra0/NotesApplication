import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CreateNotesComponent } from './create-notes/create-notes.component';
import { CommonModule } from '@angular/common'
import { MynotesComponent } from './mynotes/mynotes.component';
import { UpdateNotesComponent } from './update-notes/update-notes.component';
import { LoginNotesComponent } from './login-notes/login-notes.component';
import { RouteNotesComponent } from './route-notes/route-notes.component';
import { RegisteUserComponent } from './registe-user/registe-user.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'



@NgModule({
  declarations: [
    AppComponent,
    CreateNotesComponent,
    MynotesComponent,
    UpdateNotesComponent,
    LoginNotesComponent,
    RouteNotesComponent,
    RegisteUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
