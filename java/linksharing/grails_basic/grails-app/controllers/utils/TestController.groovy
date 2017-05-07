package utils

import grails.converters.JSON

class TestController {

    static responseFormats = ["json"]
//    static defaultAction = "test"

    static allowedMethods = [index: 'GET', update: ['PUT', 'POST']]

    def index() {
      //  render "Params ${params} ${session.name}"
//2 action implicit chaining, interceptors called twice demo
forward(action: "renderText", params: [actionName : actionName,
firstInterceptorRan: params.firstInterceptorRan])
    }

    def test(){
        render "${session.name} Action : ${actionName}"
    }

//default action invoked from urlMappings
    def noAction(){
        render "${controllerName}/${actionName}"
    }

//Error uri handling
    def save(){
        response.sendError(404)
    }

//For allowedMethods tests
    def update(){
        render ":Updated"
    }

//For testing "render"
    def firstScope() {
        render view: 'first'
    }

    String renderText(){
        render "Params ${params}"
    }



}
