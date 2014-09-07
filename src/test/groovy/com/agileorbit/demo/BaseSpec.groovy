package com.agileorbit.demo

import com.agileorbit.demo.util.AndroidHelper
import com.agileorbit.demo.util.AppleHelper
import com.agileorbit.demo.util.Helper

import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.remote.DesiredCapabilities

import spock.lang.Specification

abstract class BaseSpec extends Specification {
    AppiumDriver driver
    Helper h

    def setup() {
        String platform = System.getProperties().getProperty("platform")

        switch (platform) {
            case "ios":
                File appDir = new File("binaries")
                File app = new File(appDir, "Demo.app")
                DesiredCapabilities capabilities = new DesiredCapabilities()
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS)
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator")
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath())
                driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
                h = new AppleHelper(driver)
                break
            case "android":
                File appDir = new File("binaries")
                File app = new File(appDir, "Demo.apk")
                DesiredCapabilities capabilities = new DesiredCapabilities()
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath())
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120)
                driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
                h = new AndroidHelper(driver)
                break
            default:
                throw new IllegalStateException("unsupported platform: '" + platform + "'")
        }
    }

    def cleanup() {
        if (driver != null) driver.quit()
    }
}