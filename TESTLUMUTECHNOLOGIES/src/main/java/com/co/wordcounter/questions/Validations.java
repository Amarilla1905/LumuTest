        package com.co.wordcounter.questions;


        import net.serenitybdd.screenplay.Question;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

        public class Validations {

            private final String generatedText;
            public Validations(String generatedText) {
                this.generatedText = generatedText;
            }


            public static Question<Boolean> compareCharacterCount(String generatedText) {
                return actor -> {
                    WebDriver driver = ThucydidesWebDriverSupport.getDriver();
                    WebElement characterCountElement = driver.findElement(By.id("character_count"));
                    int characterCountFromPage = Integer.parseInt(characterCountElement.getText().trim());
                    System.out.println("Numero de caracteres en la pagina :" + characterCountFromPage);
                    int characterCountInGeneratedText = generatedText.length();
                    System.out.println("Número de caracteres en el texto generado: " + characterCountInGeneratedText);
                    return characterCountFromPage == characterCountInGeneratedText;
                };
            }

            // Método para comparar el número de palabras
            public static Question<Boolean> compareWordCount(String generatedText) {
                return actor -> {
                    WebDriver driver = ThucydidesWebDriverSupport.getDriver();
                    WebElement wordCountElement = driver.findElement(By.id("word_count"));
                    int wordCountFromPage = Integer.parseInt(wordCountElement.getText().trim());
                    System.out.println("Numero de palabras en la pagina :" + wordCountFromPage);
                    int wordCountInGeneratedText = generatedText.split("\\s+").length;
                    System.out.println("Número de palabras en el texto generado: " + wordCountInGeneratedText);
                    return wordCountFromPage == wordCountInGeneratedText;

                };
            }

            public static Question<Boolean> WordsRepeat(String generatedText) {
                return actor -> {
                    WebDriver driver = ThucydidesWebDriverSupport.getDriver();
                    WebElement wordOneMostRepeat= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[1]/span[2]"));
                    String wordFirstRepeat = (wordOneMostRepeat.getText().trim());
                    System.out.println("Palabra que más se repite en el texto: " + wordFirstRepeat);


                    WebElement wordTwoMostRepeat= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[2]/span[2]"));
                    String wordSecondRepeat = (wordTwoMostRepeat.getText().trim());
                    System.out.println("Palabra que más se repite en el texto: " + wordSecondRepeat);

                    WebElement wordThreeMostRepeat= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[3]/span[2]"));
                    String wordThirdRepeat = (wordThreeMostRepeat.getText().trim());
                    System.out.println("Palabra que más se repite en el texto: " + wordThirdRepeat);
                    return true;
                };
            }
        }
