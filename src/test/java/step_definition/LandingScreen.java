package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LandingScreen extends TestBase {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        By dismissTut = By.xpath("//android.widget.TextView[@text = 'OK']");
        By actionOnClick = By.xpath("//android.widget.TextView[@text = 'Action on click']");
        By clickOnCancel = By.id("android:id/button2");
        By checkBox= By.id("com.home.button.bottom:id/notification_checkbox");
        By strength = By.id("com.home.button.bottom:id/vibration_strength_title_textview");
        By strengthOkBtn=  By.id("com.home.button.bottom:id/ok_textview");
        By btnColor = By.xpath("//android.widget.TextView[@text = 'Button color']");
        By color = By.xpath("//android.widget.FrameLayout[4]");



        @Given("^Dismiss the tutorial$")
        public void dismissTheTutorial() {
                driver.findElement(dismissTut).click();
        }

        @And("^Select Action on click and print all the elements$")
        public void selectActionOnClickAndPrintAllTheElements() {
                driver.findElement(actionOnClick).click();
                for( int i =0; i<13; i++){
                 String item = driver.findElement(By.xpath("//android.widget.CheckedTextView["+i+"]")).getText();
                 System.out.println(item);
                }
                 driver.findElement(clickOnCancel).click();

        }

        @And("^scroll down to the bottom$")
        public void scrollDownToTheBottom() {
                (new TouchAction(driver)).press(PointOption.point(461,1886))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(PointOption.point(671,1323)).release().perform();
        }

        @And("^Uncheck the show notification checkbox$")
        public void uncheckTheShowNotificationCheckbox() {
             By.id("com.home.button.bottom:id/notification_checkbox");
                driver.findElement(checkBox).click();

        }


        @Then("^Select vibration strength and set it to 100$")
        public void selectVibrationStrengthAndSetItTo() {
                driver.findElement(strength).click();
                (new TouchAction(driver)).press(PointOption.point(822, 1134))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(PointOption.point(889, 1145)).release().perform();
                driver.findElement(strengthOkBtn).click();
        }

        @And("^Select button color and set it to violet$")
        public void selectButtonColorAndSetItToViolet() {
                driver.findElement(btnColor).click();
                driver.findElement(color).click();
        }

}