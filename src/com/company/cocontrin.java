package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Geometry {

}

class Shape extends Geometry {

}

class Circle extends Shape {

}
class co_contra_in {

    public static void main(String[] args) {
        List<? extends Shape> shapes = new ArrayList<Circle>();

        //shapes.add(new Circle());

        demoCoandContra();
    }


    public static void demoCoandContra() {
        List<? extends Number> numbers = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();

        // Covariant - only GET possible, not Add.
        //Number i = 10;
        //numbers.add(i);

        ints.add(1);
        ints.add(1);
        ints.add(1);

        numbers = ints;

        System.out.println(numbers.get(0));

        List<? super Integer> superInts = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        objects.add(12);
        objects.add(0.002);
        objects.add(12L);
        objects.add(new Object());

        superInts = objects;
        superInts.add(1);
        //superInts = doubles; error, as Double is not super of Integer

        //possible if we know the values in advance...not possible at runtime
        Double n = (Double) superInts.get(1);
        System.out.println(n); //prints 0.002

        //possible if we know the values in advance...not possible at runtime
        //because 1 is double, but String
        //Exception in thread "main" java.lang.ClassCastException: java.lang.Double cannot be cast to java.lang.String
        String n1 = (String) superInts.get(1);
        System.out.println(n1);


        System.out.println(superInts.get(2).getClass().getSimpleName()); // prints Long

        List<? super Number> superNumbers = new ArrayList<>();
        List<? super Double> superDoubles = new ArrayList<>();

        superDoubles = superNumbers;
    }
}
