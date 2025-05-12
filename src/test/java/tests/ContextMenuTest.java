package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest(){
        Actions actions = new Actions(driver);
        basePage.getUrl("https://the-internet.herokuapp.com/context_menu");
        WebElement link = driver.findElement(By.id("hot-spot"));
        actions.contextClick(link).perform();
        Alert alert = driver.switchTo().alert();
        String allertText = alert.getText();
        assertEquals(allertText, "You selected a context menu");
        alert.accept();
    }
}
