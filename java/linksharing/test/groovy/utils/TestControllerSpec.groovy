package utils

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TestController)
class TestControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    //Test allowedMethod *** Starts ****
    def "test_TestController.update_does_not_accept_#method_requests"(String method) {
        when:
        request.method = method
        TestController controller = new TestController()
        controller.update()
        controller.update()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'GET']
    }

    def "test_TestController.update_accepts_POST_requests"() {
        when:
        request.method = 'POST'
        TestController controller = new TestController()
        controller.update()

        then:
        response.status == SC_OK
    }
//Test allowedMethod *** Ends ****

//Test "render"
    void "test render view"() {
        when:
        controller.firstScope()

        then:
        '/test/first' == view
    }

//Test response code
    void 'test save'() {
        when:
        controller.save()

        then:
        response.status == 404
    }
}
