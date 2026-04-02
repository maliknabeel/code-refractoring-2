package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class AddParameterExample {

    public static String getDescription() {
        return "Add Parameter: When a method needs more information from its callers, add a " +
               "parameter for an object that can pass on this information. Consider whether " +
               "another refactoring (like Introduce Parameter Object) might be more appropriate " +
               "if you find yourself adding many parameters.";
    }

    public static String getBadCode() {
        return """
                // BAD: getContact() can only return the first contact — no way to select
                class Customer {
                    private List<Contact> contacts;

                    Contact getContact() {
                        return contacts.get(0);  // always first — caller has no control
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Parameter added to let the caller specify which contact type they want
                class Customer {
                    private List<Contact> contacts;

                    Contact getContact(String contactType) {
                        return contacts.stream()
                            .filter(c -> c.getType().equals(contactType))
                            .findFirst()
                            .orElseThrow();
                    }
                }
                """;
    }

    public static class BadExample {
        public String formatDate(int day, int month, int year) {
            // Always uses "-" separator — no flexibility
            return day + "-" + month + "-" + year;
        }
    }

    public static class GoodExample {
        public String formatDate(int day, int month, int year, String separator) {
            // Caller can now choose the separator
            return day + separator + month + separator + year;
        }
    }
}
