package com.agileorbit.demo

import spock.lang.Unroll

class AccountSpec extends BaseSpec {

    @Unroll
    def "create account for #name"(String name, String email, String password, String confirmPassword) {
        given:
        def button = h.name("Create Account")

        when:
        def input = h.name('Name')
        input.sendKeys(name)
        button.click()

        then:
        h.text("Password is blank") != null

        where:
        name        | email                     | password | confirmPassword
        "Bobby"     | "bobby@bobby.com"         | "pass"   | "pass"
        "George"    | "george@george.com"       | "pass"   | "pass"
        "Alexander" | "alexander@alexander.com" | "pass"   | "pass"
        "Mark"      | "mark@mark.com"           | "pass"   | "pass"
        "John"      | "john@john.com"           | "pass"   | "pass"
        "Steve"     | "steve@steve.com"         | "pass"   | "pass"
        "Doug"      | "doug@doug.com"           | "pass"   | "pass"
        "Henry"     | "henry@henry.com"         | "pass"   | "pass"
        "Michael"   | "michael@michael.com"     | "pass"   | "pass"
        "Peter"     | "peter@peter.com"         | "pass"   | "pass"
        "Mary"      | "mary@mary.com"           | "pass"   | "pass"
        "Rachel"    | "rachel@rachel.com"       | "pass"   | "pass"
    }
}