package edu.pafiast.refractoring.techniques.movingfeatures;

public class ExtractClassExample {

    public static String getDescription() {
        return "Extract Class: When one class is doing the work of two, create a new class and " +
               "move the relevant fields and methods from the old class into the new class. " +
               "A class that is too large is doing too much; split it up so each class has " +
               "a single, clear responsibility.";
    }

    public static String getBadCode() {
        return """
                // BAD: Person class handles both personal info AND phone-number details
                class Person {
                    private String name;
                    private String officeAreaCode;
                    private String officeNumber;

                    String getTelephoneNumber() {
                        return "(" + officeAreaCode + ") " + officeNumber;
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: TelephoneNumber extracted to its own class
                class TelephoneNumber {
                    private String areaCode;
                    private String number;

                    String getTelephoneNumber() {
                        return "(" + areaCode + ") " + number;
                    }
                }

                class Person {
                    private String name;
                    private TelephoneNumber officeTelephone = new TelephoneNumber();

                    String getTelephoneNumber() {
                        return officeTelephone.getTelephoneNumber();
                    }
                }
                """;
    }
}
