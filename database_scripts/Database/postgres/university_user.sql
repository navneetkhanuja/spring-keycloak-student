--user is reserve keyword in postgres so updated to users
CREATE TABLE users (
  id SERIAL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) NOT NULL,
  username varchar(45) NOT NULL,
  password varchar(300) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO users VALUES (1,'John','Smith','john@gmail.com','john','$2a$10$F8sB/g1Ye6e/bi8ZeYig.OSYyFUDCPjDgo.1lvyiiQ8Fcr8gnbhbG'),(2,'Sachin','Dave','sachin@gmail.com','sachin','$2a$10$ScVCKTI48YezLftvZIyOculWARv/ros/isElYZyqpT1ftVJ4g/zai');