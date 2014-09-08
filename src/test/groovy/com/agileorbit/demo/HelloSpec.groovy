package com.agileorbit.demo

import spock.lang.Unroll

class HelloSpec extends BaseSpec {

    @Unroll
    def "say hello to #english in spanish"(String english, String spanish) {
        given:
        def input = h.text()
        def button = h.name("Send")

        expect:
        input.sendKeys(english)
        button.click()
        h.text("Hola $spanish") != null

        where:
        english     | spanish
        "Bobby"     | "Roberto"
        "George"    | "Jorge"
        "Alexander" | "Alejandro"
        "Mark"      | "Marcos"
        "John"      | "Juan"
        "Steve"     | "Esteban"
        "Doug"      | "Diego"
        "Henry"     | "Enrique"
        "Michael"   | "Miguel"
        "Peter"     | "Pedro"
        "Mary"      | "Maria"
        "Rachel"    | "Raquel"
    }
}