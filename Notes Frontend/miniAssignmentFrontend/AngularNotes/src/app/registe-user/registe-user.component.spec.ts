import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteUserComponent } from './registe-user.component';

describe('RegisteUserComponent', () => {
  let component: RegisteUserComponent;
  let fixture: ComponentFixture<RegisteUserComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisteUserComponent]
    });
    fixture = TestBed.createComponent(RegisteUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
