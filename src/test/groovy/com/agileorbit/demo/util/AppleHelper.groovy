package com.agileorbit.demo.util

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class AppleHelper implements Helper {

    AppiumDriver driver

    AppleHelper(AppiumDriver webDriver) {
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
        element(By.className("UIATextField"))
    }

    MobileElement text(int xpathIndex) {
        element(forText(xpathIndex))
    }

    By forText(int xpathIndex) {
        By.xpath("//UIAStaticText[" + xpathIndex + "]")
    }

    MobileElement text(String text) {
        element(forText(text))
    }

    By forText(String text) {
        String up = text.toUpperCase();
        String down = text.toLowerCase();
        By.xpath("//UIAStaticText[@visible=\"true\" and (contains(translate(@name,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@hint,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@label,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@value,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\"))]")
    }

    MobileElement textExact(String text) {
        element(forTextExact(text))
    }

    By forTextExact(String text) {
        By.xpath("//UIAStaticText[@visible=\"true\" and (@name=\"" + text
                + "\" or @hint=\"" + text + "\" or @label=\"" + text
                + "\" or @value=\"" + text + "\")]")
    }
}