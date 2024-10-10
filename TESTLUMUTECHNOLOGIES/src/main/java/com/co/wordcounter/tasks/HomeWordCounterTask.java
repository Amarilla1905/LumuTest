package com.co.wordcounter.tasks;

import com.co.wordcounter.interactions.GenerateRandomText;
import com.co.wordcounter.interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Random;

import static com.co.wordcounter.userinterfaces.HomeWordCounterPage.*;

public class HomeWordCounterTask implements Task {
    private final boolean wordsRepetition; // true si se permite repetición
    private final int wordCount; // Número de palabras a generar
    public static String textTrue;

    public HomeWordCounterTask(boolean wordsRepetition) {
        this.wordsRepetition = wordsRepetition;
        this.wordCount = new Random().nextInt(36) + 5; // Generar un número aleatorio entre 5 y 40
    }

    public static HomeWordCounterTask withRepetition() {
        return Tasks.instrumented(HomeWordCounterTask.class, true);
    }

    public static Performable withoutRepetition() {
        return Tasks.instrumented(HomeWordCounterTask.class, false);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        GenerateRandomText generateRandomText = wordsRepetition
                ? GenerateRandomText.withRepetitionWords(wordCount)
                : GenerateRandomText.withoutRepetitionWords(wordCount);
        actor.attemptsTo(generateRandomText);
        String randomText = generateRandomText.getGeneratedText();
        textTrue = randomText;
        System.out.println("Generated text: " + randomText);
        actor.attemptsTo(
                Click.on(TXT_TEXT),
                Enter.theValue(randomText).into(TXT_TEXT),
                Pause.forSeconds(2)
        );
    }
}