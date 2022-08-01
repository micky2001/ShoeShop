import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

  sellerFormGroup: FormGroup;
  product: Product = new Product();

  productId: number=100;
  productName: string="test";
  color: string="pink";
  size: string="5";
  category: string="Sports";
  gender: string="Female";
  price: number=789;
  sellerId: number=3;
  imgUrl: string="test.jpg";
  pdesc: string="Testing";


  constructor(private productService:ProductService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit(): void {



    this.sellerFormGroup = this.formBuilder.group({
      seller: this.formBuilder.group({
        pid: [''],
        pname: [''],
        color: [''],
        size:[''],
        pcat:[''],
        pgen: [''],
        price: [''],
        sid: [''],
        imgurl: [''],
        desc: ['']
      })
    });

  }





  onSubmit(){
    console.log("Handling Submit Button");
    
    this.productName = this.sellerFormGroup.get('seller').value.pname;
    this.productId = this.sellerFormGroup.get('seller').value.pid;
    this.color = this.sellerFormGroup.get('seller').value.color;
    this.size = this.sellerFormGroup.get('seller').value.size;
    this.category = this.sellerFormGroup.get('seller').value.pcat;
    this.imgUrl = this.sellerFormGroup.get('seller').value.imgurl;
    this.pdesc = this.sellerFormGroup.get('seller').value.desc;
    this.price = this.sellerFormGroup.get('seller').value.price;
    this.sellerId = this.sellerFormGroup.get('seller').value.sid;
    this.gender = this.sellerFormGroup.get('seller').value.pgen;
    //this.router.navigate(['/products']);

  

    this.product.productId = this.productId;
    this.product.productName = this.productName;
    this.product.color = this.color;
    this.product.category = this.category;
    this.product.size = this.size;
    this.product.gender = this.gender;
    this.product.price = this.price;
    this.product.sellerId = this.sellerId;
    this.product.imgUrl = this.imgUrl;
    this.product.pdesc = this.pdesc;

    console.log(this.product);


    this.productService.createNewProduct(this.product)
      .subscribe(data=>{
        console.log(data);
        if(this.product.productName==data.productName){
          alert("Product Added Successfully");
          this.router.navigate(['/products']);
        }
      },error=>console.log(error))

    /*
    this.productService.createNewProduct(this.product)
        .subscribe(data=>{
          console.log(data);
          if(this.product.price=data.price){
            alert(`Product added successfully.`);
            this.productName ="";
            this.productId = 0;
            this.color = "";
            this.size ="";
            this.category ="";
            this.imgUrl = "";
            this.pdesc ="";
            this.price = 0;
            this.sellerId =0;
            this.gender ="";
          }
          this.router.navigate(['/products']);
        })
*/        

  }
  

}
