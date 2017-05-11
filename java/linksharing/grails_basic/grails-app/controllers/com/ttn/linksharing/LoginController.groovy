package com.ttn.linksharing

import co.UserCO
import vo.PostVO

class LoginController {

    def index() {

        if(session['user']) {
            forward(controller : 'user' , action : 'index')
        }
        else{



            render (view:"index")

        }

    }


    def loginHandler(String loginUserName , String loginPassword)
    {
        User user = User.findByUsernameAndPassword(loginUserName,loginPassword)
        flash.error=""

        if(user==null)
        {
            flash.error = 'User not found'
            render (flash.error)


        }

        else if(user.active)
        {
            session['user']=user

            redirect(controller: 'user' , action: 'index')
        }
        else
        { flash.error = 'Your account is not active'
            render (flash.error)

        }


    }

    def register(UserCO userCO)
    {

        if (userCO.hasErrors())
        {
            render(view: '/login/index')
        }
            else
        {

                User user = new User(firstname: userCO.firstName, lastname: userCO.lastName,
                        email:userCO.email, username:userCO.userName,
                        password: userCO.password,
                        confirmPassword: userCO.confirmPassword,
                        photo: userCO.photo, admin: userCO.admin)

                  if(!user.save(flush:true))
                  {   render (view:'/login/index')}

                     else {
                      session['user'] = user
                      redirect(controller: 'login', action: 'index')

                  }

           }
        }


    def logout()
    {

        session.invalidate()
        forward(controller : 'login', action : 'index')
    }
}
