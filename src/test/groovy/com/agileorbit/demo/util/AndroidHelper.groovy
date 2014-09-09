package com.agileorbit.demo.util

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class AndroidHelper implements Helper {

    AppiumDriver driver

    AndroidHelper(AppiumDriver webDriver) {
        driver = webDriver
    }

    MobileElement text() {
        element(By.className("android.widget.EditText"))
    }

    MobileElement text(int xpathIndex) {
        element(By.xpath("//android.widget.TextView[" + xpathIndex + "]"))
    }

    MobileElement text(String text) {
        element(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"))
    }

    MobileElement textExact(String text) {
        element(By.xpath("//android.widget.TextView[@text='" + text + "']"))
    }

    MobileElement find(String value) {
        element(By.xpath("//*[@content-desc=\"" + value + "\" or @resource-id=\"" + value +
            "\" or @text=\"" + value + "\"] | //*[contains(translate(@content-desc,\"" + value +
            "\",\"" + value + "\"), \"" + value + "\") or contains(translate(@text,\"" + value +
            "\",\"" + value + "\"), \"" + value + "\") or @resource-id=\"" + value + "\"]"))
    }
}
