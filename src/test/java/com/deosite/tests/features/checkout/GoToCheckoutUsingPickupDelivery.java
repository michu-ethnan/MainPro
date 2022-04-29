package com.deosite.tests.features.checkout;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.pages.PaymentPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.ChooseDelivery;
import com.deosite.tests.tasks.order.ChoosePickupLocation;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.order.Pay;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class GoToCheckoutUsingPickupDelivery {
    @Steps
    SetupSteps setupSteps;

    @Given("that {word} happens to be on the checkout with a product")
    public void ellen_goes_to_checkout(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(5),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage()
        );
    }
    @When("she selects delivery type pickup and chooses {word} as a {word}")
    public void ellen_selects_pick_up_point(String pickupLocation, String userType){
        theActorInTheSpotlight().attemptsTo(
                ChoosePickupLocation.byLocation(pickupLocation),
                FillInBillingData.type(userType),
                WaitUntil.the(SUBMIT_BUTTON, isClickable()),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(PaymentPage.PLACE_ORDER_BUTTON, isPresent())

        );
    }
    @Then("she should see that she is on the payment page")
    public void ellen_should_be_on_the_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PaymentPage.PLACE_ORDER_BUTTON).isDisplayed(),
                Click.on(PaymentPage.DELETE_PRODUCT_BUTTON_ON_PAYMENT_PAGE_AFTER_ORDER)
        );
    }
}
