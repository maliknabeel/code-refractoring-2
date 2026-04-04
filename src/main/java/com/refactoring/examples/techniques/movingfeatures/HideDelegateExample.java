package com.refactoring.examples.techniques.movingfeatures;

public class HideDelegateExample {

    public static String getDescription() {
        return "Hide Delegate: When a client is calling a delegate class of an object, create " +
               "methods on the server to hide the delegate. This reduces coupling: if the delegate " +
               "changes, only the server needs to change — clients are shielded.";
    }

    public static String getBadCode() {
        return """
                // BAD: Client reaches through Person to get Department, then Manager
                // Client knows too much about the internal structure
                class Client {
                    String getManagerName(Person person) {
                        Department dept = person.getDepartment(); // reaches through
                        return dept.getManager().getName();       // chain of calls
                    }
                }

                class Person {
                    Department department;
                    Department getDepartment() { return department; }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Person hides the delegate — client only talks to Person
                class Person {
                    private Department department;

                    String getManagerName() {
                        return department.getManager().getName(); // hidden from client
                    }
                }

                class Client {
                    String getManagerName(Person person) {
                        return person.getManagerName(); // simple, no chain
                    }
                }
                """;
    }
}
