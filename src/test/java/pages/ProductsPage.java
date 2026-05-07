package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> productItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = "[data-test='product-sort-container']")
    private WebElement sortDropdown;

    private final By cartBadge = By.className("shopping_cart_badge");

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public int getProductCount() {
        return productItems.size();
    }

    public void sortBy(String visibleText) {
        new Select(sortDropdown).selectByVisibleText(visibleText);
    }

    public List<Double> getPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public List<String> getProductNames() {
        return productNames.stream().map(WebElement::getText).toList();
    }

    public void addProductToCart(String productName) {
        click(productActionButton(productName, "Add to cart"));
    }

    public void clickCartIcon() {
     driver.get("https://www.saucedemo.com/cart.html");
    }

    public String getCartBadgeText() {
        return findAll(cartBadge).isEmpty() ? "0" : findAll(cartBadge).get(0).getText();
    }

    private WebElement productActionButton(String productName, String buttonText) {
        String xpath = "//div[@class='inventory_item'][.//div[text()='" + productName + "']]//button[text()='" + buttonText + "']";
        return driver.findElement(By.xpath(xpath));
    }
}
