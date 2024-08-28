package com.ericsson.oss.services.countermanagement.impl

import com.ericsson.cds.cdi.support.spock.CdiSpecification

/* This is just a sample test for reference, feel free to delete it at any point */

class DateResolverBeanSpec extends CdiSpecification{

    def 'Test that two separate date calls, one second apart, are not equal'() {
        setup:
            def dateResolver = new DateResolverBean()

        and: 'We call the date resolver once and store its output as a string'
            def time1 = dateResolver.resolveCurrentDate().toString()

        and: 'We wait for one second'
            sleep(1000)

        and: 'We call the date resolver once more and store the output as a different string'
            def time2 = dateResolver.resolveCurrentDate().toString()

        when: 'We check whether the dates we stored as strings are equal'
            def result = time1 == time2

        then: 'The result should be false'
            assert !result
    }
}
