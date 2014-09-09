package com.agileorbit.demo.util

import io.appium.java_client.MobileElement
import org.openqa.selenium.By

trait Helper {

    MobileElement element(By locator) {
        driver.findElement(locator)
    }

    List<MobileElement> elements(By locator) {
        driver.findElements(locator)
    }

    void back() {
        driver.navigate().back()
    }

    List<MobileElement> tags(String tagName) {
        elements(forTags(tagName))
    }

    By forTags(String tagName) {
        By.className(tagName)
    }

    MobileElement name(String text) {
        element(By.name(text))
    }

    abstract MobileElement text()

    abstract MobileElement text(int xpathIndex)

    abstract MobileElement text(String text)

    abstract MobileElement textExact(String text)

    abstract MobileElement secureText(int xpathIndex)
}
