package com.ttn.linksharing

import grails.interceptors.Matcher


class ApplicationInterceptor {

    public ApplicationInterceptor() {
        matchAll()
    }

    boolean before() {

       /* if(session.user==null) {
            log.info("guest user")
        } else if (session.user.admin==true) {
            log.info("admin user")
        } else if(session.user.admin == false) {
            log.info("normal user")
        }*/
        log.info "controller: $controllerName, action:$actionName -> $params"
        true
    }

    boolean after() { true }

    void afterView() {
// no-op
    }
}