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

    public static class BadExample {
        public static class Person {
            private String name;
            private int    age;

            public Person(String name, int age) { this.name = name; this.age = age; }
            public String getName()   { return name; }
            public void   setName(String n) { this.name = n; }
            public int    getAge()    { return age; }
            public String toString()  { return name + " (" + age + ")"; }
        }

        // Employee purely delegates — IS-A holds, so this is unnecessary delegation
        public static class Employee {
            private final Person person;
            private int employeeNumber;

            public Employee(String name, int age, int employeeNumber) {
                this.person = new Person(name, age);
                this.employeeNumber = employeeNumber;
            }

            public String getName()   { return person.getName(); }    // delegation
            public int    getAge()    { return person.getAge(); }     // delegation
            public String toString()  { return person.toString(); }   // delegation
            public int    getEmployeeNumber() { return employeeNumber; }
        }
    }

    public static class GoodExample {
        public static class Person {
            private String name;
            private int    age;

            public Person(String name, int age) { this.name = name; this.age = age; }
            public String getName()   { return name; }
            public void   setName(String n) { this.name = n; }
            public int    getAge()    { return age; }
            @Override public String toString() { return name + " (" + age + ")"; }
        }

        // Employee IS-A Person — extend, not delegate
        public static class Employee extends Person {
            private final int employeeNumber;

            public Employee(String name, int age, int employeeNumber) {
                super(name, age);
                this.employeeNumber = employeeNumber;
            }

            public int getEmployeeNumber() { return employeeNumber; }
            // getName(), getAge(), toString() all inherited — no delegation noise
        }
    }
}
