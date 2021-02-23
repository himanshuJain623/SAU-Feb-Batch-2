import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  @Output() addUser: EventEmitter<any> = new EventEmitter();

  profileForm = new FormGroup({
    firstName: new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z ]*')]),
    lastName: new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z ]*')]),
    contactNumber: new FormControl('',[Validators.required,Validators.maxLength(10)]),
    dateOfBirth: new FormControl('',Validators.required),
    city: new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z ]*')]),
    pinCode: new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(6)])
  });

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.addUser.emit(this.profileForm.controls);
  }
}
