import { ActivatedRoute } from '@angular/router';
import { CustomerService } from './../../services/customer.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/common/customer';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  customer: Customer[];
  currentId: number;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.listCustomers();
  }

  listCustomers() {
    this.customerService.getCustomer().subscribe(
      data => {
        this.customer = data;
      }
    )
  }


}
