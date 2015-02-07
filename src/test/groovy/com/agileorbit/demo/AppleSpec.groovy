package com.agileorbit.demo

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Specification

class AppleSpec extends Specification {
    AppiumDriver driver

    def setup() {
        File appDir = new File("binaries")
        File app = new File(appDir, "Demo.app")
        DesiredCapabilities capabilities = new DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator")
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath())
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities)
    }

    def cleanup() {
        if (driver != null) driver.quit()
    }

    def "say hello in spanish"() {
        given:
        MobileElement input = (MobileElement)driver.findElementByClassName("UIATextField")
        MobileElement button = (MobileElement)driver.findElementByName("Send")

        when:
        input.sendKeys("Bobby")
        button.click()

        then:
        driver.findElement(By.name("Hola Roberto")) != null
    }
}
