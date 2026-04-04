package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class ReplaceErrorCodeWithExceptionExample {

    public static String getDescription() {
        return "Replace Error Code with Exception: When a method returns a special code to " +
               "indicate an error, throw an exception instead. Error codes are easily ignored " +
               "by callers and pollute every call site with error-checking boilerplate. " +
               "Exceptions separate the happy path from the error handling.";
    }

    public static String getBadCode() {
        return """
                // BAD: Error code -1 returned — easy to ignore, pollutes call sites
                int withdraw(double amount) {
                    if (amount > balance) return -1;  // error code
                    balance -= amount;
                    return 0;   // success code
                }

                // Caller must remember to check:
                if (account.withdraw(amount) == -1) {
                    handleOverdraft();  // easily forgotten!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Exception thrown — compiler forces caller to handle it
                void withdraw(double amount) throws InsufficientFundsException {
                    if (amount > balance) {
                        throw new InsufficientFundsException(amount - balance);
                    }
                    balance -= amount;
                }

                // Caller:
                try {
                    account.withdraw(amount);
                } catch (InsufficientFundsException e) {
                    handleOverdraft(e.getShortfall());
                }
                """;
    }
}
