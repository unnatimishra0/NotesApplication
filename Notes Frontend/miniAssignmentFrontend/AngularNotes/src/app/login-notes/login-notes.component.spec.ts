import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginNotesComponent } from './login-notes.component';

describe('LoginNotesComponent', () => {
  let component: LoginNotesComponent;
  let fixture: ComponentFixture<LoginNotesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginNotesComponent]
    });
    fixture = TestBed.createComponent(LoginNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
