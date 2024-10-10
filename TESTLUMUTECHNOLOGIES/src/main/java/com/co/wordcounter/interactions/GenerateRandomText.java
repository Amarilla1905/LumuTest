    package com.co.wordcounter.interactions;

    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.Interaction;
    import net.serenitybdd.screenplay.Tasks;

    import java.util.HashSet;
    import java.util.Random;
    import java.util.Set;

    public class GenerateRandomText implements Interaction {

        private final boolean wordsRepetition;
        private final int wordsNumber;
        private static String generatedText; // Texto generado

        public GenerateRandomText(boolean wordsRepetition, int wordsNumber) {
            this.wordsRepetition = wordsRepetition;
            this.wordsNumber = wordsNumber;
        }

        public static GenerateRandomText withRepetitionWords(int wordsNumber) {
            return Tasks.instrumented(GenerateRandomText.class, true, wordsNumber);
        }

        public static GenerateRandomText withoutRepetitionWords(int wordsNumber) {
            return Tasks.instrumented(GenerateRandomText.class, false, wordsNumber);
        }



        @Override
        public <T extends Actor> void performAs(T actor) {
            generatedText = wordsRepetition ? generateTextWithRepetition(wordsNumber) : generateTextWithoutRepetition(wordsNumber);

        }

        public static String getGeneratedText() {
            return generatedText;
        }

        private String generateTextWithRepetition(int wordsNumber) {
            String[] words = {
                    "Selenium", "Screenplay", "automated", "test", "Java", "Serenity", "framework",
                    "actor", "performance", "browser", "interaction", "task", "assertion", "element",
                    "page", "object", "method", "debug", "automation", "script", "driver",
                    "click", "input", "form", "validate", "execute", "build", "compile", "run",
                    "inspect", "find", "navigate", "load", "complete", "assert", "verify", "timeout",
                    "alert", "scroll", "function", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
            };

            Random random = new Random();
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < wordsNumber; i++) {
                text.append(words[random.nextInt(words.length)]).append(" ");
            }
            return text.toString().trim();
        }

        private String generateTextWithoutRepetition(int wordCount) {
            String[] words = {
                    "Selenium", "Screenplay", "automated", "test", "Java", "Serenity", "framework",
                    "actor", "performance", "browser", "interaction", "task", "assertion", "element",
                    "page", "object", "method", "debug", "automation", "script", "driver",
                    "click", "input", "form", "validate", "execute", "build", "compile", "run",
                    "inspect", "find", "navigate", "load", "complete", "assert", "verify", "timeout",
                    "alert", "scroll", "function", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
            };

            Set<String> usedWords = new HashSet<>();
            Random random = new Random();
            StringBuilder text = new StringBuilder();
            while (usedWords.size() < wordCount && usedWords.size() < words.length) {
                String word = words[random.nextInt(words.length)];
                if (usedWords.add(word)) {
                    text.append(word).append(" ");
                }
            }
            return text.toString().trim();
        }//
    }
