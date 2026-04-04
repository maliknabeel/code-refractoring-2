package edu.pafiast.refractoring.techniques.composingmethods;

public class ExtractMethodExample {

    public static String getDescription() {
        return "Extract Method: When you have a code fragment that can be grouped together, " +
               "turn the fragment into a method whose name explains the purpose of the method. " +
               "This reduces method length, eliminates code duplication, and improves readability.";
    }

    public static String getBadCode() {
        return """
                // BAD: One long method doing everything - hard to read and understand
                void printOwing() {
                    double outstanding = 0.0;

                    // print banner
                    System.out.println("*************************");
                    System.out.println("***** Customer Owes *****");
                    System.out.println("*************************");

                    // calculate outstanding
                    for (Order order : orders) {
                        outstanding += order.getAmount();
                    }

                    // print details
                    System.out.println("name: " + name);
                    System.out.println("amount: " + outstanding);
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Each logical section is its own well-named method
                void printOwing() {
                    printBanner();
                    double outstanding = calculateOutstanding();
                    printDetails(outstanding);
                }

                private void printBanner() {
                    System.out.println("*************************");
                    System.out.println("***** Customer Owes *****");
                    System.out.println("*************************");
                }

                private double calculateOutstanding() {
                    double result = 0.0;
                    for (Order order : orders) {
                        result += order.getAmount();
                    }
                    return result;
                }

                private void printDetails(double outstanding) {
                    System.out.println("name: " + name);
                    System.out.println("amount: " + outstanding);
                }
                """;
    }
}
