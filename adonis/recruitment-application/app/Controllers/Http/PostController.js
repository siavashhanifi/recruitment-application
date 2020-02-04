'use strict'
const APPLICANT = 1;

class PostController {

    static get inject () {
        return ['App/Model/User'];
    }

    static get inject () {
        return ['App/Integration/DbHandler'];
    }

    constructor(DbHandler){
        this.dbHandler = DbHandler;
    }
    register({ request, response }) {
        const params = request.all();
        const name = params('name');
        const surname = params('surname');
        const ssn = params('ssn');
        const email = params('email');
        const password = params('password');
        const role_id = APPLICANT;
        const username = params('username');
        var user = new User(name, surname, ssn, email, password, role_id, username);
        this.dbHandler.register(user);
        console.log(params['email'] + params['password']);
    }
    login({ request, response }) {
        const params = request.all();
        const email = params['email'];
        const password = params['password'];
        console.log(email + password);
      }
    logout({ request, response }) {
        //
    }
}

module.exports = PostController
