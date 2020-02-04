'use strict'

class User {

  constructor(name, surname,ssn,email,password,role_id,username){
    this.name = name;
    this.surname = surname;
    this.ssn = ssn;
    this.email = email;
    this.password = password;
    this.role_id = role_id;
    this.username = username;
  }

}

module.exports = User
