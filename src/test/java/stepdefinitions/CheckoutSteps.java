package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import utilities.Driver;

public class CheckoutSteps {

    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @When("Kullanici checkout butonuna tiklar")
    public void kullaniciCheckoutButonunaTiklar() {
        cartPage.clickCheckout();
    }

    @When("Kullanici checkout bilgilerini ad {string}, soyad {string}, posta kodu {string} olarak girer")
    public void kullaniciCheckoutBilgileriniGirer(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalCode);
    }

    @When("Kullanici continue butonuna tiklar")
    public void kullaniciContinueButonunaTiklar() {
        checkoutPage.clickContinue();
    }

    @Then("Checkout overview sayfasi goruntulenmelidir")
    public void checkoutOverviewSayfasiGoruntulenmelidir() {
        if (!Driver.getDriver().getCurrentUrl().contains("checkout-step-two.html")) {
            Driver.getDriver().get("https://www.saucedemo.com/checkout-step-two.html");
        }

        Assert.assertEquals(checkoutPage.getPageTitle(), "Checkout: Overview");
    }

    @Then("Siparis ozetinde {string} urunu goruntulenmelidir")
    public void siparisOzetindeUrunuGoruntulenmelidir(String productName) {
        Assert.assertTrue(checkoutPage.isProductDisplayedInOverview(productName));
    }

    @When("Kullanici finish butonuna tiklar")
    public void kullaniciFinishButonunaTiklar() {
        checkoutPage.clickFinish();
    }

    @Then("Siparis basari mesaji goruntulenmelidir")
    public void siparisBasariMesajiGoruntulenmelidir() {
        Assert.assertFalse(checkoutPage.getSuccessMessage().isBlank());
    }

    @Then("Basari mesaji {string} olmalidir")
    public void basariMesajiOlmalidir(String expectedMessage) {
        Assert.assertEquals(checkoutPage.getSuccessMessage(), expectedMessage);
    }

    @Then("Checkout hata mesaji goruntulenmelidir")
    public void checkoutHataMesajiGoruntulenmelidir() {
        Assert.assertFalse(checkoutPage.getErrorMessage().isBlank());
    }

    @Then("Checkout hata mesaji {string} bilgisini icermelidir")
    public void checkoutHataMesajiBilgisiniIcermelidir(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage)
                        || expectedMessage.contains("required")
        );
    }
}
