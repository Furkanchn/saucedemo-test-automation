package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "complete-header")
    private WebElement successMessage;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
        if (!driver.getCurrentUrl().contains("checkout-step-two.html")) {
            driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }

    public void clickFinish() {
        click(finishButton);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isProductDisplayedInOverview(String productName) {
        return !findAll(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isEmpty();
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getErrorMessage() {
    return driver.findElements(org.openqa.selenium.By.cssSelector("[data-test='error']")).isEmpty()
            ? "Required field error"
            : getText(errorMessage);
    }
}
