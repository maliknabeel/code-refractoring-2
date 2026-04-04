package com.refactoring.examples.techniques.organizingdata;

public class ReplaceDataValueWithObjectExample {

    public static String getDescription() {
        return "Replace Data Value with Object: When you have a data item that needs additional " +
               "data or behaviour, turn the data item into an object. A simple string for a " +
               "telephone number is fine at first, but a real telephone number has formatting, " +
               "validation, and area code extraction — it deserves its own class.";
    }

    public static String getBadCode() {
        return """
                // BAD: Customer stores phone and email as raw strings with no behaviour
                class Customer {
                    private String name;
                    private String phoneNumber;   // just a raw string
                    private String emailAddress;  // just a raw string

                    boolean isValidPhone() {
                        return phoneNumber != null && phoneNumber.matches("\\\\d{10}");
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: PhoneNumber is now an object with its own validation and behaviour
                class PhoneNumber {
                    private final String number;

                    public PhoneNumber(String number) {
                        if (!number.matches("\\\\d{10}")) throw new IllegalArgumentException("Invalid phone");
                        this.number = number;
                    }

                    String getAreaCode() { return number.substring(0, 3); }
                    String format()      { return "(" + number.substring(0,3) + ") " + number.substring(3,6) + "-" + number.substring(6); }
                }

                class Customer {
                    private String name;
                    private PhoneNumber phoneNumber;
                }
                """;
    }
}
