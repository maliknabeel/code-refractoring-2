package com.refactoring.examples.techniques.organizingdata;

public class EncapsulateFieldExample {

    public static String getDescription() {
        return "Encapsulate Field: When you have a public field, make it private and provide " +
               "accessors. Public fields allow external code to directly modify internal state, " +
               "bypassing any invariants or validation the class might want to enforce.";
    }

    public static String getBadCode() {
        return """
                // BAD: Public fields allow unrestricted, unvalidated external modification
                class Person {
                    public String name;   // anyone can set to null or ""
                    public int    age;    // anyone can set to -999
                }

                // External code:
                person.name = null;   // no validation!
                person.age  = -5;     // nonsensical value allowed
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Fields are private; setters enforce invariants
                class Person {
                    private String name;
                    private int    age;

                    public String getName() { return name; }
                    public void   setName(String name) {
                        if (name == null || name.isBlank())
                            throw new IllegalArgumentException("Name cannot be blank");
                        this.name = name;
                    }

                    public int  getAge() { return age; }
                    public void setAge(int age) {
                        if (age < 0 || age > 150)
                            throw new IllegalArgumentException("Age out of range");
                        this.age = age;
                    }
                }
                """;
    }
}
