package com.ttn.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def "constraintsOfResourceItemExcludingUserUniqueness"() {
        given:
        ReadingItem resourceItemObj = new ReadingItem(resource: resource, user: user, isRead: isRead)

        when:
        boolean result = resourceItemObj.validate()

        then:
        result == excepted

        where:
         resource           | user       | isRead | excepted
         new LinkResource() | new User() | true   | true
         null               | new User() | true   | false
         new LinkResource() | null       | true   | false
         new LinkResource() | new User() | null   | false
    }

    def "validatingUniqueReadingItem"() {
        given:
        Resource resource = new LinkResource()
        User user = new User()
        ReadingItem readingItem = new ReadingItem(resource: resource, user: user, isRead: true)
        ReadingItem newReadingItem = new ReadingItem(resource: resource, user: user, isRead: false)

        when:
        readingItem.save(flush: true)
        newReadingItem.save(flush: true)

        then:
        !readingItem.errors.allErrors.size()
        newReadingItem.errors.allErrors.size()==1
        newReadingItem.errors.getFieldError('resource')

    }

    def "tostringCheck"() {
        setup:
        User user = new User()
        Resource resource = new DocumentResource()
        ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: isRead)

        when:
        result == readingItem.toString()

        then:
        noExceptionThrown()

        where:
        userName          | description | isRead | result
        "priyanka.naik"   | "grails"    | true   | "priyanka.naik read the grails: true"
    }
}
