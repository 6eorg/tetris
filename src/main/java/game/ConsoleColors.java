package game;

import java.util.Random;

public enum ConsoleColors {

    //reset ==> reset to standard
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String code;

    ConsoleColors(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ConsoleColors getRandomColor(){
        ConsoleColors[] colors = ConsoleColors.values();
        Random rnd = new Random();
        int randomInt = rnd.nextInt(colors.length);
        System.out.println("inside Console color: random value: " + randomInt);
        return colors[randomInt];
    }

}