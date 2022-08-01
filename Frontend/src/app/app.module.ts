import { ReactiveFormsModule } from '@angular/forms';
import { ProductService } from './services/product.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SearchComponent } from './components/search/search.component';

import { HttpClientModule } from '@angular/common/http';

import { Routes, RouterModule} from '@angular/router';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { CustomerloginComponent } from './components/customerlogin/customerlogin.component';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { CustomerRegistrationComponent } from './components/customer-registration/customer-registration.component';
import { SellerComponent } from './components/seller/seller.component';

const routes: Routes = [
  {path: 'seller', component: SellerComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'customer-registration', component: CustomerRegistrationComponent},
  {path: 'customerlogin', component: CustomerloginComponent},
  {path: 'customer-details', component: CustomerDetailsComponent},
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'products/:id', component: ProductDetailsComponent},
  {path: 'category/:cat', component: ProductListComponent},
  {path: 'gender/:cat', component: ProductListComponent},
  {path: 'search/:keyword', component: ProductListComponent},
  {path: 'category', component: ProductListComponent},
  {path: 'products', component: ProductListComponent},
  {path: '', redirectTo: '/customerlogin', pathMatch: 'full'},
  {path: '**', redirectTo: '/products', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    CustomerloginComponent,
    CustomerDetailsComponent,
    CustomerRegistrationComponent,
    SellerComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
