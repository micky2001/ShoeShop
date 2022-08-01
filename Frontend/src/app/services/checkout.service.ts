import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderDetails } from '../common/order-details';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {
  private baseUrl: string = 'http://localhost:9090/api/order';
  constructor(private httpClient: HttpClient) { }

  getOrder(): Observable<any> {
    return this.httpClient.get(this.baseUrl)

  }

  public getOrderDetails(id:number):Observable<any>{
    // console.log("in getcustomerdetail");
     return this.httpClient.get(`${this.baseUrl}/${id}`);
   }

  public createNewOrder(order: OrderDetails): Observable<any> {
    return this.httpClient.post(this.baseUrl, order);
  }
}
