package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

public class HideMethodExample {

    public static String getDescription() {
        return "Hide Method: When a method is not used by any other class, make the method " +
               "private. A class's public interface should be as small as possible. Excess " +
               "public methods expose implementation details and make the class harder to change " +
               "without breaking clients.";
    }

    public static String getBadCode() {
        return """
                // BAD: formatName() and validateInput() are public but only used internally
                class AccountFormatter {
                    public String format(Account account) {
                        return formatName(account) + " - " + account.getBalance();
                    }

                    public String formatName(Account account) {  // should be private!
                        return account.getLastName() + ", " + account.getFirstName();
                    }

                    public boolean validateInput(String input) {  // should be private!
                        return input != null && !input.isBlank();
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Internal helpers are private — only format() is public API
                class AccountFormatter {
                    public String format(Account account) {
                        return formatName(account) + " - " + account.getBalance();
                    }

                    private String formatName(Account account) {   // hidden
                        return account.getLastName() + ", " + account.getFirstName();
                    }

                    private boolean validateInput(String input) {  // hidden
                        return input != null && !input.isBlank();
                    }
                }
                """;
    }
}
