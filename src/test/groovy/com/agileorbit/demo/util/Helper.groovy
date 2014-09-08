package com.agileorbit.demo.util

import io.appium.java_client.MobileElement
import org.openqa.selenium.By

interface Helper {

    MobileElement element(By locator)

    List<MobileElement> elements(By locator)

    void back()

    List<MobileElement> tags(String tagName)

    MobileElement name(String text)

    MobileElement text()

    MobileElement text(int xpathIndex)

    MobileElement secureText(int xpathIndex)

    MobileElement text(String text)

    MobileElement textExact(String text)
}