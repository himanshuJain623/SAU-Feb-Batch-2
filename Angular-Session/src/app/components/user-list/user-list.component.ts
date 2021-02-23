import { Component, OnInit } from '@angular/core';
import { UserFormService } from 'src/app/services/UserForm/user-form.service';
import {UserListService} from "../../services/UserList/user-list.service";


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  usersList;
  constructor(private userListService:UserListService) { 
  }

  ngOnInit(): void {
    // fetch data from users list service
    this.fetchData();
  }

  addUser(user){
    this.usersList=this.userListService.addUser(user);
  }

  fetchData(){
    this.usersList=this.userListService.getUsers();
  }

  deleteUser(user){
    this.usersList=this.userListService.deleteUser(user);
  }

  key="firstName";
  reverse=false;
  sort(key){
    this.key=key;
    this.reverse=!this.reverse;
  }
}
