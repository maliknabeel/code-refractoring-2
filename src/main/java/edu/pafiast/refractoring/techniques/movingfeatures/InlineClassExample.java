package edu.pafiast.refractoring.techniques.movingfeatures;

public class InlineClassExample {

    public static String getDescription() {
        return "Inline Class: When a class isn't doing very much, move all its features into " +
               "another class and delete it. It is the opposite of Extract Class. Use it when " +
               "a class is no longer pulling its weight after refactoring.";
    }

    public static String getBadCode() {
        return """
                // BAD: TelephoneNumber is so simple it adds no value as a separate class
                class TelephoneNumber {
                    String areaCode;
                    String number;
                }

                class Person {
                    private TelephoneNumber telephone = new TelephoneNumber();

                    String getAreaCode()  { return telephone.areaCode; }
                    String getNumber()    { return telephone.number; }
                    void   setAreaCode(String arg) { telephone.areaCode = arg; }
                    void   setNumber(String arg)   { telephone.number = arg; }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: TelephoneNumber fields moved directly into Person
                class Person {
                    private String telephoneAreaCode;
                    private String telephoneNumber;

                    String getTelephoneAreaCode()  { return telephoneAreaCode; }
                    String getTelephoneNumber()    { return telephoneNumber; }
                    void   setTelephoneAreaCode(String arg) { telephoneAreaCode = arg; }
                    void   setTelephoneNumber(String arg)   { telephoneNumber = arg; }

                    String getFormattedNumber() {
                        return "(" + telephoneAreaCode + ") " + telephoneNumber;
                    }
                }
                """;
    }
}
