import { CartItem } from './../../common/cart-item';
import { OrderDetails } from './../../common/order-details';
import { Router } from '@angular/router';
import { CheckoutService } from './../../services/checkout.service';
import { CartService } from 'src/app/services/cart.service';
import { FormServiceService } from './../../services/form-service.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  checkoutFormGroup: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;
  orderId: number=0;
  customerId: number=0;
  status: string="";

  cartItems: CartItem[] = [];

  order: OrderDetails = new OrderDetails();

  creditCardYears: number[] = [];
  creditCardMonths: number[] = [];

  constructor(private formBuilder: FormBuilder, private formService: FormServiceService, private cartService: CartService,
    private checkoutService: CheckoutService,
    private router: Router) { }

  ngOnInit(): void {

    this.reviewCartDetails();

    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        oid: [''],
        id: [''],
        fullName: new FormControl('', [Validators.required, Validators.minLength(2)]),
        email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
        address: new FormControl('', [Validators.required, Validators.minLength(5)]),
        gender: [],
        phone: new FormControl('', [Validators.required,Validators.pattern("^[0-9]*$"), Validators.minLength(10), Validators.maxLength(10)])
      }),
      creditCard: this.formBuilder.group({
        cardType: [''],
        nameOnCard: [''],
        cardNumber: [''],
        expirationMonth: [''],
        expirationYear: ['']
      })
    });

    // populate credit card months

    const startMonth: number = new Date().getMonth() + 1;
    console.log("startMonth: " + startMonth);

    this.formService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Retrieved credit card months: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );

    // populate credit card years

    this.formService.getCreditCardYears().subscribe(
      data => {
        console.log("Retrieved credit card years: " + JSON.stringify(data));
        this.creditCardYears = data;
      }
    );

  }


  reviewCartDetails() {

    // subscribe to cartService.totalQuantity
    this.cartService.totalQuantity.subscribe(
      totalQuantity => this.totalQuantity = totalQuantity
    );

    // subscribe to cartService.totalPrice
    this.cartService.totalPrice.subscribe(
      totalPrice => this.totalPrice = totalPrice
    );

  }

  get fullName() { return this.checkoutFormGroup.get('customer.fullName'); }
  get address() { return this.checkoutFormGroup.get('customer.address'); }
  get email() { return this.checkoutFormGroup.get('customer.email'); }
  get gender() { return this.checkoutFormGroup.get('customer.gender'); }
  get phone() { return this.checkoutFormGroup.get('customer.phone'); }



  onSubmit() {
    console.log("Handling the submit button");

    if (this.checkoutFormGroup.invalid) {
      this.checkoutFormGroup.markAllAsTouched();
      return;
    }

    //this.resetCart();
    // set up order
    this.orderId = this.checkoutFormGroup.get('customer').value.oid;
    this.customerId = this.checkoutFormGroup.get('customer').value.id;
    this.status = 'Order Placed';



    this.order.totalAmount = this.totalPrice;
    this.order.quantity = this.totalQuantity;
    //this.cartItems = this.cartService.cartItems;
    this.order.customerId= this.customerId;
    this.order.orderId= this.orderId;
    this.order.orderStatus=this.status;
    //order.productId = this.cartItems.id;






    this.checkoutService.createNewOrder(this.order)
        .subscribe(data=>{
          console.log(data);
          if(this.order.customerId=data.customerId){
            alert(`Order added successfully placed and Your Order Tracking Id is ${ this.order.orderId }.`);
            this.resetCart();
          }
          //this.router.navigate(['/products']);
        })


  }

  resetCart() {
    // reset cart data
    alert(`Thanks for ordering with Metro Shoes. Your Order successfully placed.`);
    this.cartService.cartItems = [];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);

    // reset the form
    this.checkoutFormGroup.reset();

    // navigate back to the products page
    this.router.navigateByUrl("/products");
  }
}
