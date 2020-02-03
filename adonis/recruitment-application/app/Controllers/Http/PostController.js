'use strict'

class PostController {
    register({ request, response }) {
        const params = request.all();
        console.log(params['email'] + params['password']);
    }
    login({ request, response }) {
        const params = request.post();
        console.log(params['email'] + params['password']);
      }
    logout({ request, response }) {
        //
    }
}

module.exports = PostController
