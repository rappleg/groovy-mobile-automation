package com.agileorbit.demo

import spock.lang.Unroll

class AccountSpec extends BaseSpec {

    @Unroll
    def "create account for #name"(String name, String email, String password, String confirmPassword) {
        when:
        def nameInput = h.text(1)
        nameInput.sendKeys(name)
        def emailInput = h.text(2)
        emailInput.sendKeys(email)
        def passwordInput = h.secureText(1)
        passwordInput.sendKeys(password)
        def confirmPasswordInput = h.secureText(2)
        confirmPasswordInput.sendKeys(confirmPassword)
        def button = h.name("Create Account")
        button.click()

        then:
        h.text("Welcome, $name") != null

        where:
        name        | email                     | password | confirmPassword
        "Bobby"     | "bobby@bobby.com"         | "pass"   | "pass"
        "George"    | "george@george.com"       | "pass"   | "pass"
        "Alexander" | "alexander@alexander.com" | "pass"   | "pass"
    }

    def "blank password popup should appear"() {
        when:
        def button = h.name("Create Account")
        button.click()

        then:
        h.text("Password is blank") != null
    }

    @Unroll
    def "passwords do not match popup should appear for #name"(String name, String email, String password, String confirmPassword) {
        when:
        def nameInput = h.text(1)
        nameInput.sendKeys(name)
        def emailInput = h.text(2)
        emailInput.sendKeys(email)
        def passwordInput = h.secureText(1)
        passwordInput.sendKeys(password)
        def confirmPasswordInput = h.secureText(2)
        confirmPasswordInput.sendKeys(confirmPassword)
        def button = h.name("Create Account")
        button.click()

        then:
        h.text("Passwords do not match") != null

        where:
        name        | email                     | password | confirmPassword
        "Mark"      | "mark@mark.com"           | "pass"   | "Pass"
        "John"      | "john@john.com"           | "pass"   | ""
    }
}