package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PullUpFieldExample.*;

public class PullUpFieldExampleBadExample {
    public static class Animal {}
    public static class Dog extends Animal { private String name; private String breed; }
    public static class Cat extends Animal { private String name; private String color; }

    public String getDogName(Dog d) { return d.name; }
    public String getCatName(Cat c) { return c.name; }
}
