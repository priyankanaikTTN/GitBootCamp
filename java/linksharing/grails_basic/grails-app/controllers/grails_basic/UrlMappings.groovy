package grails_basic

class UrlMappings {



    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }




        "/"(controller: "login", action: "index")

        "500"(view:'/error')
        "404"(view:'/notFound')

        /*"/test"(controller: "test",action: "noAction")
        "/errorTest"(controller: "test",action: "save")
        "/redirect"(redirect:"/test")*/
    }
}
