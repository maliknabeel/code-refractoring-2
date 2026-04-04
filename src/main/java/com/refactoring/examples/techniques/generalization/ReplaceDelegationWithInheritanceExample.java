package com.refactoring.examples.techniques.generalization;

public class ReplaceDelegationWithInheritanceExample {

    public static String getDescription() {
        return "Replace Delegation with Inheritance: When you are using delegation and are often " +
               "writing many simple delegations for the entire interface, make the delegating " +
               "class a subclass of the delegate class. This is the inverse of Replace " +
               "Inheritance with Delegation — use when the IS-A relationship genuinely holds.";
    }

    public static String getBadCode() {
        return """
                // BAD: Employee has a Person field and delegates EVERY method — pure wrapper
                class Employee {
                    private Person person = new Person();

                    String getName()    { return person.getName(); }    // delegation
                    void setName(String n) { person.setName(n); }       // delegation
                    String toString()   { return person.toString(); }   // delegation
                    // ...every method is just a delegation to person — no added value
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Employee extends Person — the IS-A relationship holds
                class Employee extends Person {
                    private int employeeNumber;
                    // getName(), setName() etc. inherited from Person — no delegation needed
                }
                """;
    }
}
