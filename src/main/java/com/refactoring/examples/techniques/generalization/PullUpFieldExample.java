package com.refactoring.examples.techniques.generalization;

public class PullUpFieldExample {

    public static String getDescription() {
        return "Pull Up Field: When two subclasses have the same field, move the field to the " +
               "superclass. Duplicate fields in subclasses cause duplicate code and inconsistency. " +
               "Moving them up eliminates the duplication and provides a single point of change.";
    }

    public static String getBadCode() {
        return """
                // BAD: Both subclasses have identical 'name' field — duplicated
                class Employee    { }
                class Salesperson extends Employee { private String name; }
                class Engineer    extends Employee { private String name; }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: 'name' pulled up to the superclass — no duplication
                class Employee {
                    protected String name;
                }
                class Salesperson extends Employee { /* name inherited */ }
                class Engineer    extends Employee { /* name inherited */ }
                """;
    }

    public static class BadExample {
        public static class Animal {}
        public static class Dog extends Animal { private String name; private String breed; }
        public static class Cat extends Animal { private String name; private String color; }

        public String getDogName(Dog d) { return d.name; }
        public String getCatName(Cat c) { return c.name; }
    }

    public static class GoodExample {
        public static class Animal {
            protected String name; // pulled up
            public String getName() { return name; }
        }
        public static class Dog extends Animal {
            private String breed;
            public Dog(String name, String breed) { this.name = name; this.breed = breed; }
            public String getBreed() { return breed; }
        }
        public static class Cat extends Animal {
            private String color;
            public Cat(String name, String color) { this.name = name; this.color = color; }
            public String getColor() { return color; }
        }
    }
}
