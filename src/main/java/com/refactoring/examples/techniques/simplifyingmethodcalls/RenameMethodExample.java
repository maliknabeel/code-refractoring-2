package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class RenameMethodExample {

    public static String getDescription() {
        return "Rename Method: When the name of a method does not reveal its purpose, change the " +
               "name of the method. The most important aspect of good code is communicating " +
               "intent. If you need a comment to explain what a method does, the method name " +
               "is probably not good enough.";
    }

    public static String getBadCode() {
        return """
                // BAD: Cryptic or misleading method names
                class Phone {
                    String getTelNum()  { return areaCode + "-" + number; }
                    boolean chk(int age) { return age >= 18; }
                    void proc()         { /* process the order */ }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Names clearly communicate purpose
                class Phone {
                    String getTelephoneNumber() { return areaCode + "-" + number; }
                    boolean isAdult(int age)    { return age >= 18; }
                    void processOrder()         { /* process the order */ }
                }
                """;
    }

    public static class BadExample {
        private String areaCode = "021";
        private String number   = "1234567";

        public String getTelNum()   { return areaCode + "-" + number; }
        public boolean chk(int age) { return age >= 18; }
        public double cal(double p, double r) { return p * r / 100; }
    }

    public static class GoodExample {
        private String areaCode = "021";
        private String number   = "1234567";

        public String getTelephoneNumber()            { return areaCode + "-" + number; }
        public boolean isAdult(int age)               { return age >= 18; }
        public double calculatePercentage(double p, double r) { return p * r / 100; }
    }
}
