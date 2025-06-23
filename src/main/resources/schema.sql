CREATE TABLE IF NOT EXISTS Taco_Order (
  id identity,
  delivery_Name VARCHAR(50) NOT NULL,
  delivery_Street VARCHAR(50) NOT NULL,
  delivery_City VARCHAR(50) NOT NULL,
  delivery_State VARCHAR(2) NOT NULL,
  delivery_Zip VARCHAR(10) NOT NULL,
  cc_number VARCHAR(16) NOT NULL,
  cc_expiration VARCHAR(5) NOT NULL,
  cc_cvv VARCHAR(3) NOT NULL,
  placed_at timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS Taco (
  id identity,
  name VARCHAR(50) NOT NULL,
  taco_order BIGINT NOT NULL,
  taco_order_key BIGINT NOT NULL,
  created_at timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS Ingredient_Ref (
  ingredient varchar(4) not null ,
  taco bigint not null ,
  taco_key bigint not null
);

CREATE TABLE IF NOT EXISTS Ingredient (
  id varchar(4) PRIMARY KEY,
  name varchar(25) not null ,
  type varchar(10) not null
);

ALTER TABLE Taco ADD FOREIGN KEY (taco_order) references Taco_Order(id);
ALTER TABLE Ingredient_Ref ADD FOREIGN KEY (ingredient) references Ingredient(id);
