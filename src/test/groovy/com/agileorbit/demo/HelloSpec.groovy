package com.agileorbit.demo

class HelloSpec extends BaseSpec {

    def "say hello in spanish with name"() {
        given:
        def input = h.text()
        def button = h.name("Send")

        when:
        input.sendKeys("Bobby")
        button.click()

        then:
        h.text("Hola Roberto") != null
    }

    def "say hello in spanish with invalid name"() {
        given:
        def input = h.text()
        def button = h.name("Send")

        when:
        input.sendKeys("foobar")
        button.click()

        then:
        h.text("Hola Usted") != null
    }    
}