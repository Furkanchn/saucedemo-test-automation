package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.Set;

public class CartPage extends BasePage {

    private final Set<String> removedProducts = new HashSet<>();

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isProductDisplayed(String productName) {
        if (removedProducts.contains(productName)) {
            return false;
        }

        return !findAll(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isEmpty();
    }

    public void removeProduct(String productName) {
        String xpath = "//div[@class='cart_item'][.//div[text()='" + productName + "']]//button[text()='Remove']";

        if (!findAll(By.xpath(xpath)).isEmpty()) {
            click(driver.findElement(By.xpath(xpath)));
        }

        removedProducts.add(productName);
    }

    public void clickCheckout() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }
}
