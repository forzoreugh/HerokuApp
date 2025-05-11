package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest(){
        basePage.getUrl("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).
                sendKeys("C:\\Program Files\\Java\\jdk-19\\LICENSE");
        driver.findElement(By.cssSelector(".button")).click();
        String nameFile = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        softAssert.assertEquals(nameFile, "LICENSE");
        softAssert.assertAll();
    }
}
