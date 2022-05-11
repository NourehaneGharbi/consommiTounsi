import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cagnotte } from 'app/models/cagnotte';
import { Observable } from 'rxjs';

import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CagnotteAddService {

  constructor( private http:HttpClient) { }

  usersUrl="http://localhost:8081/SpringMVC/retrieveAllCagnottes";
  API_URL="http://localhost:8081/SpringMVC";

    public getAllCagnottes(){
      return this.http.get<Cagnotte[]>(`${this.API_URL}/retrieveAllCagnottes`)
    }

  getAllUsersByid(id_cagnotte:number) : Observable<Cagnotte[]>{
      return this.http.get<Cagnotte[]>("http://localhost:8081/SpringMVC/findCagnotteById/"+id_cagnotte);
      }

      public addCagnotte(cagnotte:Cagnotte){
        return this.http.post<Cagnotte>("http://localhost:8081/SpringMVC/addCagnotte",cagnotte);
      }


  public getUserByEmail(email){
    return this.http.get("http://localhost:8081/SpringMVC/findCagnotteById/"+email);
  }


  deleteCagnotte(id:any){
    return this.http.delete<any>(`${this.API_URL}/removeCagnotte/`+id)
  }
  
}
