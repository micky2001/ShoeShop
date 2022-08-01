import { Users } from './../../common/users';
import { Router } from '@angular/router';
import { UsersService } from './../../services/users.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  registerForm: FormGroup;
  userId: number=0;
  userName: string="";
  password: string="";
  userType: string="";

  user: Users = new Users();
  constructor(private usersService:UsersService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      user: this.formBuilder.group({
        name:  new FormControl('', [Validators.required, Validators.minLength(2)]),
        id:  new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
        passcode: new FormControl('', [Validators.required, Validators.minLength(4), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')]),
        type: ['']

      })
    });
  }

  get name() { return this.registerForm.get('user.name'); }
  get id() { return this.registerForm.get('user.id'); }
  get passcode() { return this.registerForm.get('user.passcode'); }
  get type() { return this.registerForm.get('user.type'); }

  register() {
    if (this.registerForm.invalid) {
      this.registerForm.markAllAsTouched();
    }
    /*
    console.log("Handling the submit button");
    console.log(this.loginFormGroup.get('login').value);
    console.log("The user name is " + this.loginFormGroup.get('user').value.userId);
    */
    this.userId = this.registerForm.get('user').value.id;
    this.userName = this.registerForm.get('user').value.name;
    this.password = this.registerForm.get('user').value.passcode;
    this.userType = this.registerForm.get('user').value.type;
    //this.router.navigate(['/products']);



    this.user.userName = this.userName;
    this.user.userId = this.userId;
    this.user.password = this.password;
    this.user.userType = this.userType;

      this.usersService.createNewUser(this.user)
        .subscribe(data=>{
          console.log(data);
          if(this.user.userName=data.userName){
            alert(`Customer added successfully and Your User Id for login is ${ this.user.userId }.`);
            this.userName='';
            this.userId=0;
            this.userType='';
            this.password='';
          }
          this.router.navigate(['/products']);
        })




  }

}
