package com.refactoring.examples.techniques.movingfeatures;

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

    public static class BadExample {
        public static class Person {
            private String name;
            private String officeAreaCode;
            private String officeNumber;

            public Person(String name, String officeAreaCode, String officeNumber) {
                this.name = name;
                this.officeAreaCode = officeAreaCode;
                this.officeNumber = officeNumber;
            }

            public String getName() { return name; }

            public String getTelephoneNumber() {
                return "(" + officeAreaCode + ") " + officeNumber;
            }

            public String getOfficeAreaCode() { return officeAreaCode; }
            public String getOfficeNumber() { return officeNumber; }
        }
    }

    public static class GoodExample {
        public static class TelephoneNumber {
            private final String areaCode;
            private final String number;

            public TelephoneNumber(String areaCode, String number) {
                this.areaCode = areaCode;
                this.number = number;
            }

            public String getTelephoneNumber() {
                return "(" + areaCode + ") " + number;
            }
        }

        public static class Person {
            private final String name;
            private final TelephoneNumber officeTelephone;

            public Person(String name, TelephoneNumber officeTelephone) {
                this.name = name;
                this.officeTelephone = officeTelephone;
            }

            public String getName() { return name; }

            public String getTelephoneNumber() {
                return officeTelephone.getTelephoneNumber();
            }
        }
    }
}
