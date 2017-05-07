package com.ttn.linksharing

import vo.PostVO

class LoginController {

    def index() {

        if(session['user']) {
            forward(controller : 'user' , action : 'index')
        }
        else{


            List<PostVO> topPosts = Resource.getTopPosts()
            render topPosts

        }

    }


    def loginHandler(String username , String password)
    {
        User user = User.findByUsernameAndPassword(username,password)
        flash.error=""

        if(user==null)
        {
            flash.error = 'User not found'
            render (flash.error)


        }

        else if(user.active)
        {
            session['user']=user

            redirect(controller: 'login' , action: 'index')
        }
        else
        { flash.error = 'Your account is not active'
            render (flash.error)

        }


    }

    def register(String fname,String lname, String e_mail, String pass, String confirm,String uname)
    {

        User user = new User(firstname: fname, lastname: lname, email: e_mail, username: uname, password: pass,confirmPassword: confirm)
         if(!user.save(flush:true))
             render flash.message='Login.not.registered.user'

        else
             render  flash.message='Login.register.user'
    }

    def logout()
    {

        session.invalidate()
        forward(controller : "login", action : 'index')
    }
}
