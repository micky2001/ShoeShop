   create database demodb;
   use demodb;
 create table users (
	userid int primary key,
    username varchar(100) not null,
    passcode varchar(50) not null
);
    CREATE TABLE Customer
    (
        Customerid int PRIMARY KEY,
        custname VARCHAR(20) NOT NULL,
        Address VARCHAR(20) NOT NULL,
        gender varchar(20),
        custemail varchar(100) unique not null,
		custphone varchar(10) unique not null,
        walletBalance double not null
    );

    CREATE TABLE Seller
    (
        Sellerid int PRIMARY KEY,
        sName VARCHAR(20) NOT NULL,
        semail varchar(100) unique not null,
		sphone varchar(10) unique not null
    );

    CREATE TABLE Product
    (
        Productid int PRIMARY KEY,
        productname VARCHAR(130) not null,
        Color VARCHAR(15) NOT NULL,
        Size VARCHAR(2) NOT NULL,
        Category VARCHAR(20) NOT NULL,
        Gender VARCHAR(10) NOT NULL,
        Price double NOT NULL,
        Sellerid int,
        imgurl varchar(255) not null,
        FOREIGN KEY (Sellerid) REFERENCES Seller(Sellerid)
    );

   CREATE TABLE orderdetails (
	orderid INT PRIMARY KEY,
	customerid INT NOT NULL,
	orderstatus varchar(150) not null,
    quantity int not null,
    totalamount double not null,
	FOREIGN KEY (Customerid) REFERENCES Customer(Customerid),
    FOREIGN KEY (Productid) REFERENCES Product(Productid)
	);
	

    
    
INSERT INTO `demodb`.`users` (`userid`, `username`, `passcode`) VALUES (1, 'Subhashree', 'abc@123');
INSERT INTO `demodb`.`users` (`userid`, `username`, `passcode`) VALUES ('2', 'Mansee', 'abc@456');
INSERT INTO `demodb`.`users` (`userid`, `username`, `passcode`) VALUES ('3', 'Chandani', 'abc@789');
INSERT INTO `demodb`.`users` (`userid`, `username`, `passcode`) VALUES ('4', 'Shalu', 'def@123');



INSERT INTO `demodb`.`customer` (`Customerid`, `custname`, `Address`, `gender`, `custemail`, `custphone`, `walletBalance`) VALUES ('1', 'Subhashree', 'Tamando', 'Female', 'abc@gmail.com', '123', '100');
INSERT INTO `demodb`.`customer` (`Customerid`, `custname`, `Address`, `gender`, `custemail`, `custphone`, `walletBalance`) VALUES ('2', 'Sonali', 'Jatni', 'Female', 'def@gmail.com', '456', '200');
INSERT INTO `demodb`.`customer` (`Customerid`, `custname`, `Address`, `gender`, `custemail`, `custphone`, `walletBalance`) VALUES ('3', 'Micky', 'Nanput', 'Female', 'ghi@gmail.com', '789', '200');
INSERT INTO `demodb`.`customer` (`Customerid`, `custname`, `Address`, `gender`, `custemail`, `custphone`, `walletBalance`) VALUES ('4', 'Rocky', 'Mahura', 'Male', 'rocky@gmail.com', '1234', '500');



INSERT INTO `demodb`.`seller` (`Sellerid`, `sName`, `semail`, `sphone`) VALUES ('1', 'Subhashree', 'subha@gmail.com', '123');
INSERT INTO `demodb`.`seller` (`Sellerid`, `sName`, `semail`, `sphone`) VALUES ('2', 'Micky', 'micky@gmail.com', '456');
INSERT INTO `demodb`.`seller` (`Sellerid`, `sName`, `semail`, `sphone`) VALUES ('3', 'Rocky', 'rocky@gmail.com', '789');



ALTER TABLE customer rename COLUMN walletBalance to walletbalance;
-- alter table customer drop column wallet_balance;

ALTER TABLE product ADD pdesc varchar(255);
ALTER TABLE users ADD usertype varchar(20);

INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('1', 'product1', 'Red', '5', 'Formal', 'Male', '450', '1', 'assets/images/products/p1.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('2', 'product2', 'Black', '6', 'Casual', 'Female', '670', '2', 'assets/images/products/p2.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('3', 'product3', 'Blue', '7', 'Sports', 'Male', '786', '3', 'assets/images/products/p3.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('4', 'product4', 'Green', '8', 'Sneakers', 'Female', '678', '1', 'assets/images/products/p4.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('5', 'product1', 'Red', '5', 'Formal', 'Male', '450', '1', 'assets/images/products/p5.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('6', 'product2', 'Black', '6', 'Casual', 'Female', '670', '2', 'assets/images/products/p6.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('7', 'product3', 'Blue', '7', 'Sports', 'Male', '786', '3', 'assets/images/products/p7.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('8', 'product4', 'Green', '8', 'Sneakers', 'Female', '678', '1', 'assets/images/products/p8.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('9', 'product1', 'Red', '5', 'Formal', 'Male', '450', '1', 'assets/images/products/p9.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('10', 'product2', 'Black', '6', 'Casual', 'Female', '670', '2', 'assets/images/products/p10.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('11', 'product3', 'Blue', '7', 'Sports', 'Male', '786', '3', 'assets/images/products/p11.png','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('12', 'product4', 'Green', '8', 'Sneakers', 'Female', '678', '1', 'assets/images/products/p12.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
. They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('13', 'product1', 'Red', '5', 'Formal', 'Male', '450', '1', 'assets/images/products/p13.png','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('14', 'product2', 'Black', '6', 'Casual', 'Female', '670', '2', 'assets/images/products/p14.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('15', 'product3', 'Blue', '7', 'Sports', 'Male', '786', '3', 'assets/images/products/p15jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('16', 'product4', 'Green', '8', 'Sneakers', 'Female', '678', '1', 'assets/images/products/p16.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');

INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('21', 'Product5', 'Pink', '9', 'Formal', 'Male', '1790', '1', 'assets/images/products/p21.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('22', 'Product6', 'Purple', '10', 'Casual', 'Female', '1056', '2', 'assets/images/products/p22.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('23', 'Product7', 'yellow', '11', 'Sports', 'Male', '16255', '3', 'assets/images/products/p23.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('24', 'Product8', 'white', '12', 'Sneakers', 'Female', '6252', '2', 'assets/images/products/p24.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('25', 'Product5', 'Pink', '9', 'Formal', 'Male', '1790', '1', 'assets/images/products/p25.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('26', 'Product6', 'Purple', '10', 'Casual', 'Female', '1056', '2', 'assets/images/products/p9.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('27', 'Product7', 'yellow', '11', 'Sports', 'Male', '16255', '3', 'assets/images/products/p10.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
 They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('28', 'Product8', 'white', '12', 'Sneakers', 'Female', '6252', '2', 'assets/images/products/p11.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('29', 'Product7', 'yellow', '11', 'Sports', 'Male', '16255', '3', 'assets/images/products/p10.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');
INSERT INTO `demodb`.`product` (`Productid`, `productname`, `Color`, `Size`, `Category`, `Gender`, `Price`, `Sellerid`, `imgurl`,`pdesc`) VALUES ('30', 'Product8', 'white', '12', 'Sneakers', 'Female', '6252', '2', 'assets/images/products/p11.jpg','A shoe is a type of footwear. It is an item of clothing. Shoes come in pairs, with one shoe for each foot.
They are worn for business and ceremonial functions. They are also worn for fashion. Slippers are a kind of indoor shoe.');



UPDATE `demodb`.`product` SET `imgurl` = 'assets/images/products/p11.jpg' WHERE (`Productid` = '11');
UPDATE `demodb`.`product` SET `imgurl` = 'assets/images/products/p15.jpg' WHERE (`Productid` = '15');



select * from users;
select * from customer;
select * from seller;
select * from product;

select * from orderdetails;