

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandartTest extends BeforeAfter {
    private String label = "Введіть, будь-ласка, номер свого мобільного телефону";
    private String registerLink = "Зареєструватися";
    private String forgetLink = "Забули пароль?";
    private String myPhone = "935527787";
    private String errorMessage = "Введіть від 1 до 100 символів";

    @Test
    public void testVklad(){
        driver.switchTo().frame(0);
        WebElement elem = driver.findElement(By.id("usd"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()", elem);
        executor.executeScript("arguments[0].click()", elem);
        executor.executeScript("document.getElementById('usd').click()");

        WebElement button = driver.findElement(By.id("button_DE00_12_usd"));

        executor.executeScript("arguments[0].click()", button);

        WebElement register = driver.findElement(By.partialLinkText("Зареєструватися"));
        Assert.assertEquals(register.getText(), registerLink);

        WebElement forget = driver.findElement(By.partialLinkText("Забули"));
        Assert.assertEquals(forget.getText(), forgetLink);

        WebElement text = driver.findElement(By.id("form_DE00_12_usd")).findElement(By.tagName("h3"));
        Assert.assertEquals(text.getText(), label);

        WebElement cancelButton = driver.findElement(By.id("forpreload")).findElement(By.linkText("Скасувати"));

        WebElement nextButton = driver.findElement(By.id("forpreload")).findElement(By.linkText("Далі"));

        WebElement telephone = driver.findElement(By.id("phone_DE00_12_usd"));
        telephone.sendKeys(myPhone);

        executor.executeScript("arguments[0].click()", nextButton);

        WebElement error = driver.findElement(By.className("errorMSG"));
        Assert.assertEquals(error.getText(), errorMessage);

        executor.executeScript("arguments[0].click()", cancelButton);
    }
}
