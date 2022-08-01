import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl: string = 'http://localhost:9090/api/products';

  constructor(private httpClient: HttpClient) { }


  getProduct(theProductId: number): Observable<any> {

    // need to build URL based on product id
    const productUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get(productUrl);
  }

  public getProductList(theCategory: string): Observable<any> {
    // need to build URL based on category id
    if(theCategory=='All')
        return this.httpClient.get(this.baseUrl);
    if(theCategory=='Male' || theCategory=='Female')
        return this.httpClient.get(`${this.baseUrl}/gender/${theCategory}`);
    const searchUrl = `${this.baseUrl}/category/${theCategory}`;
    return this.httpClient.get(searchUrl);
  }


  searchProducts(theKeyword: string): Observable<any> {

    // need to build URL based on the keyword
    const searchUrl = `${this.baseUrl}/search/${theKeyword}`;

    return this.getProducts(searchUrl);
  }

  private getProducts(searchUrl: string): Observable<any> {
    return this.httpClient.get(searchUrl);
  }

  public createNewProduct(product: Product): Observable<any> {
    return this.httpClient.post(this.baseUrl, product);
  }

}

interface GetResponse {
  _embedded: {
    products: Product[];
  }
}
