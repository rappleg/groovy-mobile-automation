package com.agileorbit.demo.util

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class AppleHelper implements Helper {

    AppiumDriver driver

    AppleHelper(AppiumDriver webDriver) {
        driver = webDriver
    }

    MobileElement text() {
        element(By.className("UIATextField"))
    }

    MobileElement text(int xpathIndex) {
        element(By.xpath("//UIATextField[" + xpathIndex + "]"))
    }

    MobileElement text(String text) {
        String up = text.toUpperCase()
        String down = text.toLowerCase()
        element(By.xpath("//UIAStaticText[@visible=\"true\" and (contains(translate(@name,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@hint,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@label,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@value,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\"))]"))
    }

    MobileElement textExact(String text) {
        element(By.xpath("//UIAStaticText[@visible=\"true\" and (@name=\"" + text
                + "\" or @hint=\"" + text + "\" or @label=\"" + text
                + "\" or @value=\"" + text + "\")]"))
    }

    MobileElement secureText(int xpathIndex) {
        element(By.xpath("//UIASecureTextField[" + xpathIndex + "]"))
    }    
}

