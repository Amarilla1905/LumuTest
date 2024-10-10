package com.co.wordcounter.stepsdefinitions;

import com.co.wordcounter.interactions.GenerateRandomText;
import com.co.wordcounter.questions.Validations;
import com.co.wordcounter.tasks.HomeWordCounterTask;
import com.co.wordcounter.userinterfaces.HomeWordCounterPage;
import com.co.wordcounter.utils.Url;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.PerformsTasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class wordCounterValidStepsDefinitions {
    @Managed
    WebDriver hisDriver;


    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisDriver));
    }


    @Given("^that the user can access the web page\\.$")
    public void thatTheUserCanAccessTheWebPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(Url.URL));
    }

    @When("^it generates random text without repetition of words and is entered in the field$")
    public void itGeneratesRandomTextWithoutRepetitionOfWordsAndIsEnteredInTheField() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                HomeWordCounterTask.withoutRepetition()
        );
    }




    @Then("^the number of characters per word will be validated\\.$")
    public void theNumberOfCharactersPerWordWillBeValidated() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validations.compareCharacterCount(HomeWordCounterTask.textTrue), Matchers.is(true)));

    }

    @Then("^the number of words will be validated$")
    public void theNumberOfWordsWillBeValidated() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validations.compareWordCount(HomeWordCounterTask.textTrue), Matchers.is(true)));

    }
}






