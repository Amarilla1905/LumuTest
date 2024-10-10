    package com.co.wordcounter.runners;

    import cucumber.api.CucumberOptions;
    import cucumber.api.SnippetType;
    import net.serenitybdd.cucumber.CucumberWithSerenity;
    import org.junit.runner.RunWith;

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = "src/test/resources/features/word_counter_validations.feature",
            snippets = SnippetType.CAMELCASE,
            glue = "com.co.wordcounter.stepsdefinitions")
    public class wordCounterValidations {
    }
