package com.agileorbit.demo

import com.agileorbit.demo.util.AppleHelper
import com.agileorbit.demo.util.Helper

import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.remote.DesiredCapabilities

import spock.lang.Specification
import spock.lang.Unroll

class LocaleSpec extends Specification {
    AppiumDriver driver
    Helper h

    @Unroll
    def "verify #locale greeting is displayed"(String locale, String greeting) {
        setup:
        String language = locale.split("_")[0]

        File appDir = new File("binaries")
        File app = new File(appDir, "LocaleDemo.app")
        DesiredCapabilities capabilities = new DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator")
        capabilities.setCapability("language", language)
        capabilities.setCapability("locale", locale)
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath())
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
        h = new AppleHelper(driver)

        expect:
        h.text(greeting) != null

        where:
        locale  | greeting
        "en_US" | "Welcome to the conference"
        "de_DE" | "Willkommen auf der konferenz"
        "es_ES" | "Bienvenidos a la conferencia"
    }

    def cleanup() {
        if (driver != null) driver.quit()
    }
}