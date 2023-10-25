import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNotesComponent } from './create-notes.component';

describe('CreateNotesComponent', () => {
  let component: CreateNotesComponent;
  let fixture: ComponentFixture<CreateNotesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateNotesComponent]
    });
    fixture = TestBed.createComponent(CreateNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
