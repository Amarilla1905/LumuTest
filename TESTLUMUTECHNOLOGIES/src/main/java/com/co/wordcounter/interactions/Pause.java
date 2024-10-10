    package com.co.wordcounter.interactions;

    import net.serenitybdd.screenplay.Actor;
    import net.serenitybdd.screenplay.Interaction;

    public class Pause {

        public static PauseForSeconds forSeconds(int seconds) {
            return new PauseForSeconds(seconds);
        }

        public static class PauseForSeconds implements Interaction {
            private final int seconds;

            public PauseForSeconds(int seconds) {
                this.seconds = seconds;
            }

            @Override
            public <T extends Actor> void performAs(T actor) {
                try {
                Thread.sleep(seconds * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }