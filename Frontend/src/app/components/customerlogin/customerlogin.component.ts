import { Router } from '@angular/router';
import { UsersService } from './../../services/users.service';
import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/common/users';
import { FormGroup, FormBuilder, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {

  loginFormGroup: FormGroup;


  id: number;
  pass: string;
  user: Users = new Users();
  type: string;
  constructor(private usersService:UsersService, private formBuilder: FormBuilder, private router:Router){}

  ngOnInit(): void {

    this.loginFormGroup = this.formBuilder.group({
      user: this.formBuilder.group({
        userId: [''],
        password: [''],
        userType: ['']

      })
    });

  }



onSubmit() {
  /*
  console.log("Handling the submit button");
  console.log(this.loginFormGroup.get('login').value);
  console.log("The user name is " + this.loginFormGroup.get('user').value.userId);
  */
  this.id = this.loginFormGroup.get('user').value.userId;
  this.pass = this.loginFormGroup.get('user').value.pass;
  this.type = this.loginFormGroup.get('user').value.userType;
  this.usersService.getUserDetails(this.id)
    .subscribe(data=>{
      if(data==null){
        alert("Invalid login! Register If account doesn't exists.");
        this.id=0;
        this.router.navigate(['/customer-registration']);
      }
      else if(this.user.password != data.pass){
        alert("Invalid Password..");
        this.id=0;
      }
      else if(this.type == 'Seller'){
      console.log(data);
      this.user=data;
      this.router.navigate(['/seller']);
    }else{
      this.router.navigate(['/products']);
    }
    },error=>{
      alert("not found ..please register");
      this.router.navigate(['/customer-registration']);
    });
  //this.router.navigate(['/products']);
}


}
