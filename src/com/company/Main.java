package com.company;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Computer {
    private SoundCard card;

    public SoundCard getCard() {
        return card;
    }

    public void setCard(SoundCard card) {
        this.card = card;
    }
}

class SoundCard {
    private Optional<USB> usb;

    public Optional<USB> getUsb() {
        return usb;
    }



    public void setUsb(Optional<USB> usb) {
        this.usb = usb;
        //d.addAll(a)
    }

    public double solution(double N) {
        // from STO, f(n) = Floor(phi^n / sqrt(5) + 1/2), where phi = (1 + sqrt(5)) / 2

        final double inverseSqrt5 = 1 / Math.sqrt(5);
        final double phi = (1 + Math.sqrt(5)) / 2;

        int result = (int) Math.floor(Math.pow(phi, N) * inverseSqrt5 + 0.5);
        String temp = String.valueOf(result);

        if(temp.length() <= 6) return result;

        return Integer.valueOf(temp.substring(temp.length() - 6, temp.length()));
    }
}

class USB {

}

public class Main {
    public static void main(String[] args) {
        double i = new SoundCard().solution(36);

        System.out.println(i);

	    MyList m = new My();

	    m.add("suresh");

        Function<Integer, Integer> f1 = n1 -> n1 * 2;
        System.out.println(new MyClass().addSome("some"));

        UserValidation validation = UserValidation.nameIsNotEmpty().and(UserValidation.eMailContainsAtSign()).and(UserValidation.ageIsValid());
        User gregor = new User("", 0, "mail@mailinator.com");
        ValidationResult result = validation.apply(gregor);

        System.out.println(result.getReason().orElse(""));

        System.out.println(f1.apply(23));

        Computer c = new Computer();

        Optional<USB> card = Optional.of(c)
                .map(Computer::getCard)
                .flatMap(SoundCard::getUsb);
    }
}
