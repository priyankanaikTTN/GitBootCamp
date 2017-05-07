package com.ttn.linksharing


class LoginInterceptor {


    LoginInterceptor() {
        matchAll().excludes(controller:"login")
    }

    boolean before() {

        if (!(session['user']))
    {
        redirect(controller: 'login', action: 'index')
        false
    }
        true
    }

    boolean after() {

        log.info("action:$actionName : -> $params")



        true }

    void afterView() {
        // no-op
    }
}
