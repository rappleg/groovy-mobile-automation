package com.agileorbit.demo

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Specification

class AndroidSpec extends Specification {
    AppiumDriver driver

    def setup() {
        File appDir = new File("binaries")
        File app = new File(appDir, "Demo.apk")
        DesiredCapabilities capabilities = new DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    def cleanup() {
        if (driver != null) driver.quit()
    }

    def "say hello in spanish"() {
        given:
        MobileElement input = (MobileElement)driver.findElementByClassName("android.widget.EditText")
        MobileElement button = (MobileElement)driver.findElementByName("Send")

        when:
        input.sendKeys("Bobby")
        button.click()

        then:
        driver.findElement(By.name("Hola Roberto")) != null
    }
}