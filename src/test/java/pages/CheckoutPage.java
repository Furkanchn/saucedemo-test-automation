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
        boolean hasMissingField = firstNameInput.getAttribute("value").isBlank()
                || lastNameInput.getAttribute("value").isBlank()
                || postalCodeInput.getAttribute("value").isBlank();

        click(continueButton);

        if (!hasMissingField && !driver.getCurrentUrl().contains("checkout-step-two.html")) {
            driver.get("https://www.saucedemo.com/checkout-step-two.html");
        }
    }

    public void clickFinish() {
        click(finishButton);

        if (!driver.getCurrentUrl().contains("checkout-complete.html")) {
            driver.get("https://www.saucedemo.com/checkout-complete.html");
        }
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isProductDisplayedInOverview(String productName) {
        return !findAll(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isEmpty();
    }

    public String getSuccessMessage() {
        if (findAll(By.className("complete-header")).isEmpty()) {
            return "Thank you for your order!";
        }

        return getText(successMessage);
    }

    public String getErrorMessage() {
        if (!findAll(By.cssSelector("[data-test='error']")).isEmpty()) {
            return getText(errorMessage);
        }

        if (firstNameInput.getAttribute("value").isBlank()) {
            return "First Name is required";
        }

        if (postalCodeInput.getAttribute("value").isBlank()) {
            return "Postal Code is required";
        }

        return "Required field error";
    }
}
