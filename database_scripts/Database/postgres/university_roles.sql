DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id SERIAL NOT NULL ,
  role varchar(45) NOT NULL,
  user_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);


INSERT INTO roles VALUES (1,'STUDENT',1),(2,'PROFESSOR',2);