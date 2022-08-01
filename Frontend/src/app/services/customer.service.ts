import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../common/customer';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl: string = 'http://localhost:9090/api/customers';
  constructor(private httpClient: HttpClient) { }

  getCustomer(): Observable<any> {
    return this.httpClient.get(this.baseUrl)

  }

  public getCustomerDetails(id:number):Observable<any>{
    // console.log("in getcustomerdetail");
     return this.httpClient.get(`${this.baseUrl}/customer/${id}`);
   }

  public createNewCustomer(customer: Customer): Observable<any> {
    return this.httpClient.post(this.baseUrl, customer);
  }

}
