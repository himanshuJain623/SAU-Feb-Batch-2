import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserFormService {

  constructor() { }

  useDetails(detailsObj){
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
  }
}
