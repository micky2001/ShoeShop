import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from '../common/users';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseUrl: string = 'http://localhost:9090/api/users';
  constructor(private httpClient: HttpClient) { }

  getUser(): Observable<any> {
    return this.httpClient.get(this.baseUrl)

  }

  public getUserDetails(id:number):Observable<any>{
    // console.log("in getcustomerdetail");
     return this.httpClient.get(`${this.baseUrl}/${id}`);
   }

  public createNewUser(user: Users): Observable<any> {
    return this.httpClient.post(this.baseUrl, user);
  }
}
