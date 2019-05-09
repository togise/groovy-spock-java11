package com.togise

import com.togise.hello.Hello
import spock.lang.Specification

class AppTest extends Specification {

    def "application has a greeting"() {
        setup:
        def app = new App()
        Hello hello = new Hello(str: "str")

        when:
        def result = app.greeting

        then:
        result != null
        hello != null
    }

    def "when the variable in the where clause is named with the same name with in some other test in this class but the types are different, the test is trying to cast it to the wrong type"() {
        App app = Mock()

        when:
        new String()

        then:
        app.getGreeting() >> hello

        where:
        hello << ["str"] // matches the name of the variable on line 14
    }
}
