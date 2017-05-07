package demoCo

import grails.validation.Validateable
import groovy.transform.ToString
import org.hibernate.validator.internal.metadata.facets.Validatable

/**
 * Created by priyanka on 5/5/17.
 */
@ToString
class EmployeeCo implements Validateable {

    String firstname;
    String lastname;
}
