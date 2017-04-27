package com.ttn.linksharing

import enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ResourceRating)
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def "checkResourceRating"() {
        given:
        ResourceRating resourceRating = new ResourceRating(resource: resource, user: user, score: score)

        when:
        Boolean valid = resourceRating.validate()

        then:
        valid == result

        where:
        resource               | user      | score | result
        new DocumentResource() | new User()| 3     | true
        null                   | new User()| 3     | false
        new DocumentResource() | null      | 3     | false
        new DocumentResource() | new User()| 10    | false
        new DocumentResource() | new User()| 0     | false

    }

    @Unroll
    def "validateUniqueResourceRating"() {

        given:
        User user = new User()
        LinkResource linkResource = new LinkResource()

        ResourceRating resourceRating = new ResourceRating(resource: linkResource ,user: user, score: 3)
        ResourceRating newResourceRating = new ResourceRating(resource: linkResource, user: user, score: 4)

        when:
        resourceRating.save(flush: true)
        newResourceRating.save(flush: true)

        then:
        !resourceRating.errors.allErrors.size()
        newResourceRating.errors.allErrors.size()==1
        newResourceRating.errors.getFieldError('resource')
    }

    def "tostringCheck"() {
        setup:
        User user = new User()
        Resource resource = new DocumentResource()
        ResourceRating resourceRating = new ResourceRating(user: user, resource: resource, score: score)

        when:
        result == resourceRating.toString()

        then:
        noExceptionThrown()

        where:
        userName          | description | score | result
        "priyanka.naik"   | "grails"    | 5     | "priyanka.naik rated grails by 5"
    }
}
