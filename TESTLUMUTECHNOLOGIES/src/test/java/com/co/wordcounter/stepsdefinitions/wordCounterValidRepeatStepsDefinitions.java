        package com.co.wordcounter.stepsdefinitions;

        import com.co.wordcounter.questions.Validations;
        import com.co.wordcounter.tasks.HomeWordCounterTask;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import net.serenitybdd.screenplay.GivenWhenThen;
        import net.serenitybdd.screenplay.actors.OnStage;
        import org.hamcrest.Matchers;

        public class wordCounterValidRepeatStepsDefinitions {

            @When("^it generates random text with repetition of words and is entered in the field$")
            public void itGeneratesRandomTextWithRepetitionOfWordsAndIsEnteredInTheField() {
                OnStage.theActorInTheSpotlight().attemptsTo(
                        HomeWordCounterTask.withRepetition()
                );
            }

            @Then("^the words more repeat$")
            public void theWordsMoreRepeat() {
                    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validations.WordsRepeat(HomeWordCounterTask.textTrue), Matchers.is(true)));


            }
        }
