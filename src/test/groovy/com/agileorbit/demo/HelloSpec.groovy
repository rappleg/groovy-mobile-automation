package com.agileorbit.demo

class HelloSpec extends BaseSpec {

    def "say hello in spanish"() {
        given:
        def input = h.text()
        def button = h.name("Send")

        when:
        input.sendKeys("Bobby")
        button.click()

        then:
        h.text("Hola Roberto") != null
    }
}