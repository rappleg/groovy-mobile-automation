package com.agileorbit.demo.util

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class AndroidHelper implements Helper {

    AppiumDriver driver

    AndroidHelper(AppiumDriver webDriver) {
        driver = webDriver
    }

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

    MobileElement text() {
        element(By.className("android.widget.EditText"))
    }

    MobileElement text(int xpathIndex) {
        element(forText(xpathIndex))
    }

    By forText(int xpathIndex) {
        By.xpath("//android.widget.TextView[" + xpathIndex + "]")
    }

    MobileElement text(String text) {
        element(forText(text))
    }

    By forText(String text) {
        By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")
    }

    MobileElement textExact(String text) {
        element(forTextExact(text))
    }

    By forTextExact(String text) {
        By.xpath("//android.widget.TextView[@text='" + text + "']")
    }

    MobileElement find(String value) {
        element(forFind(value))
    }

    By forFind(String value) {
        By.xpath("//*[@content-desc=\"" + value + "\" or @resource-id=\"" + value +
            "\" or @text=\"" + value + "\"] | //*[contains(translate(@content-desc,\"" + value +
            "\",\"" + value + "\"), \"" + value + "\") or contains(translate(@text,\"" + value +
            "\",\"" + value + "\"), \"" + value + "\") or @resource-id=\"" + value + "\"]")
    }
}