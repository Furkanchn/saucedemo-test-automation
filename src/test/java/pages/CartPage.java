package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isProductDisplayed(String productName) {
        return !findAll(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isEmpty();
    }

    public void removeProduct(String productName) {
        String xpath = "//div[@class='cart_item'][.//div[text()='" + productName + "']]//button[text()='Remove']";
        click(driver.findElement(By.xpath(xpath)));
    }

    public void clickCheckout() {
        click(checkoutButton);
    }
}
