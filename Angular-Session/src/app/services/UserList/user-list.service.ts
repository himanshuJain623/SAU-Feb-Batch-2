import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserListService {

  constructor() { }
  
  addUser(detailsObj){
    // fetch details from object
    let fetchedObj={};
    for(let key in detailsObj){
      fetchedObj[key]=detailsObj[key].value;
    }

    // store it to database
    let ndb=JSON.parse(sessionStorage.getItem("dataBase"));
    if(ndb===null)
      ndb=[];
    ndb.push(fetchedObj);
    sessionStorage.setItem("dataBase",JSON.stringify(ndb));
    return ndb;
  }

  // fetch data from session storage
  getUsers(){
    let db=JSON.parse(sessionStorage.getItem("dataBase"));
    if(db===null)
      db=[];
    return db;
  }

  deleteUser(user){
    let db=JSON.parse(sessionStorage.getItem("dataBase"));
    db=db.filter(u=>{
      return u.firstName!=user.firstName;
    })
    sessionStorage.setItem("dataBase",JSON.stringify(db));
    return db;
  }
}
