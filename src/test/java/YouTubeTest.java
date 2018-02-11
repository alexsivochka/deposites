

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeTest extends BeforeAfter {

    String titleOnPage = "ПриватБанк: Додаток \"Мої вклади\"";

    @Test(groups = {"YouTube"})
    public void privatTest() throws InterruptedException {
        driver.switchTo().frame(0);
        WebElement tab = driver.findElement(By.id("capabilitiesLink"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()", tab);

        tab.click();

        WebElement link = driver.findElement(By.id("1cpb_link"));
        executor.executeScript("arguments[0].click()", link);
        link.click();
        driver.switchTo().frame("iframe_video");

        WebElement title = driver.findElement(By.partialLinkText("ПриватБанк: Додаток \"Мої вклади\""));
        Assert.assertEquals(title.getText(), titleOnPage);
    }
}
