package com.refactoring.examples.techniques.composingmethods;

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

    public static class BadExample {
        private String name = "John";
        private double[] orderAmounts = {10.0, 20.0, 30.0};

        public String printOwing() {
            StringBuilder sb = new StringBuilder();
            double outstanding = 0.0;
            sb.append("*************************\n");
            sb.append("***** Customer Owes *****\n");
            sb.append("*************************\n");
            for (double amount : orderAmounts) {
                outstanding += amount;
            }
            sb.append("name: ").append(name).append("\n");
            sb.append("amount: ").append(outstanding).append("\n");
            return sb.toString();
        }
    }

    public static class GoodExample {
        private String name = "John";
        private double[] orderAmounts = {10.0, 20.0, 30.0};

        public String printOwing() {
            return printBanner() + calculateAndPrintDetails();
        }

        private String printBanner() {
            return "*************************\n***** Customer Owes *****\n*************************\n";
        }

        private double calculateOutstanding() {
            double result = 0.0;
            for (double amount : orderAmounts) {
                result += amount;
            }
            return result;
        }

        private String calculateAndPrintDetails() {
            double outstanding = calculateOutstanding();
            return "name: " + name + "\namount: " + outstanding + "\n";
        }
    }
}
