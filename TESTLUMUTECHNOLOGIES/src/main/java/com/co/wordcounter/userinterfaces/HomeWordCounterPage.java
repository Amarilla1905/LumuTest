    package com.co.wordcounter.userinterfaces;

    import net.serenitybdd.screenplay.targets.Target;
    import org.openqa.selenium.By;

    public class HomeWordCounterPage {
        public static final Target TXT_TEXT= Target.the("enter the text")
                .locatedBy("//*[@id='box']");
        public static final Target TXT_NUMBER_WORDS= Target.the("number of characteres")
                .locatedBy("//*[@id='word_count']");
        public static final Target TXT_NUMBER_CHARACTER = Target.the("Text showing the number of characters")
                .located(By.xpath("//*[@id='character_count']"));
        public static final Target TXT_NUMBER_CHARACTER_SPACES = Target.the("Text showing the number of characters without spaces")
                .located(By.xpath("//*[@id='character_count_no_spaces']"));
        public static final Target TXT_WORD_REPEAT_1 = Target.the("This word is the most repeated ")
                .located(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[1]/span[2]"));
        public static final Target TXT_WORD_REPEAT_2 = Target.the("This second word is the most repeated ")
                .located(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[2]/span[2]"));
        public static final Target TXT_WORD_REPEAT_3 = Target.the("This second word is the most repeated ")
                .located(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[3]/span[2]"));

    }
