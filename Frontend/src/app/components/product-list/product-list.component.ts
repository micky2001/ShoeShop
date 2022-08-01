import { CartItem } from './../../common/cart-item';
import { CartService } from './../../services/cart.service';
import { Observable } from 'rxjs';
import { ProductService } from './../../services/product.service';
import { Product } from './../../common/product';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  //products: Observable<Product[]>;
  products: Product[];
  currentCategory: string;
  searchMode: boolean;

  constructor(private productService: ProductService,private cartService: CartService, private route: ActivatedRoute) { }

  /* ngOnInit() {
    this.listProducts();
  } */

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }


  listProducts() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchProducts();
    }
    else {
      this.handleListProducts();
    }

  }

  handleSearchProducts() {

    const theKeyword: string = this.route.snapshot.paramMap.get('keyword');

    // now search for the products using keyword
    this.productService.searchProducts(theKeyword).subscribe(
      data => {
        this.products = data;
      }
    )
  }


  handleListProducts() {

    // check if "id" parameter is available
    const hasCategory: boolean = this.route.snapshot.paramMap.has('cat');

    if (hasCategory) {
      // get the "id" param string. convert string to a number using the "+" symbol
        this.currentCategory = this.route.snapshot.paramMap.get('cat');
    }
    else {
      // not category id available ... default to category id 1
      this.currentCategory = 'All';
    }

    // now get the products for the given category id
    this.productService.getProductList(this.currentCategory).subscribe(
      data => {
        this.products = data;
      }
    )
  }

  addToCart(theProduct: Product) {

    console.log(`Adding to cart: ${theProduct.productName}, ${theProduct.price}`);

    // TODO ... do the real work
    const theCartItem = new CartItem(theProduct);

    this.cartService.addToCart(theCartItem);
  }

}

