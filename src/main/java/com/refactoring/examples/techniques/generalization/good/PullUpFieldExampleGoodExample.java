package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PullUpFieldExample.*;

public class PullUpFieldExampleGoodExample {
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
