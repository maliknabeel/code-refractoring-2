package com.refactoring.examples.techniques.composingmethods;

public class ReplaceMethodWithMethodObjectExample {

    public static String getDescription() {
        return "Replace Method with Method Object: When you have a long method that uses local " +
               "variables in a way that prevents Extract Method, turn the method into its own class " +
               "so local variables become fields of the class. You can then decompose the method " +
               "into several methods on the same object.";
    }

    public static String getBadCode() {
        return """
                // BAD: Complex method with many interdependent local variables - hard to extract
                class Order {
                    double price(double primaryBase, double secondaryBase, double tertiary) {
                        double primaryDiscount  = primaryBase  * 0.1 * 2;
                        double secondaryDiscount = secondaryBase * 0.05;
                        double base = (primaryBase - primaryDiscount)
                                    + (secondaryBase - secondaryDiscount)
                                    + tertiary;
                        double importantValue1 = (base - 100) * primaryBase * 0.01;
                        double importantValue2 = importantValue1 * 0.5;
                        if ((base - importantValue1) > 1000) {
                            importantValue2 -= 20;
                        }
                        double price = base - importantValue1 - importantValue2;
                        return price;
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: PriceCalculator class makes each step a named method
                class PriceCalculator {
                    private final double primaryBase;
                    private final double secondaryBase;
                    private final double tertiary;

                    public PriceCalculator(double primaryBase, double secondaryBase, double tertiary) {
                        this.primaryBase   = primaryBase;
                        this.secondaryBase = secondaryBase;
                        this.tertiary      = tertiary;
                    }

                    double compute() {
                        double base    = calculateBase();
                        double value1  = calculateImportantValue1(base);
                        double value2  = calculateImportantValue2(base, value1);
                        return base - value1 - value2;
                    }

                    private double calculateBase() {
                        return (primaryBase  - primaryBase  * 0.1 * 2)
                             + (secondaryBase - secondaryBase * 0.05)
                             + tertiary;
                    }
                    private double calculateImportantValue1(double base) {
                        return (base - 100) * primaryBase * 0.01;
                    }
                    private double calculateImportantValue2(double base, double value1) {
                        double v2 = value1 * 0.5;
                        return (base - value1) > 1000 ? v2 - 20 : v2;
                    }
                }
                """;
    }

    public static class BadExample {
        public double price(double primaryBase, double secondaryBase, double tertiary) {
            double primaryDiscount   = primaryBase  * 0.1 * 2;
            double secondaryDiscount = secondaryBase * 0.05;
            double base = (primaryBase  - primaryDiscount)
                        + (secondaryBase - secondaryDiscount)
                        + tertiary;
            double importantValue1 = (base - 100) * primaryBase * 0.01;
            double importantValue2 = importantValue1 * 0.5;
            if ((base - importantValue1) > 1000) {
                importantValue2 -= 20;
            }
            return base - importantValue1 - importantValue2;
        }
    }

    public static class GoodExample {
        public static class PriceCalculator {
            private final double primaryBase;
            private final double secondaryBase;
            private final double tertiary;

            public PriceCalculator(double primaryBase, double secondaryBase, double tertiary) {
                this.primaryBase   = primaryBase;
                this.secondaryBase = secondaryBase;
                this.tertiary      = tertiary;
            }

            public double compute() {
                double base   = calculateBase();
                double value1 = calculateImportantValue1(base);
                double value2 = calculateImportantValue2(base, value1);
                return base - value1 - value2;
            }

            private double calculateBase() {
                return (primaryBase  - primaryBase  * 0.2)
                     + (secondaryBase - secondaryBase * 0.05)
                     + tertiary;
            }

            private double calculateImportantValue1(double base) {
                return (base - 100) * primaryBase * 0.01;
            }

            private double calculateImportantValue2(double base, double value1) {
                double v2 = value1 * 0.5;
                return (base - value1) > 1000 ? v2 - 20 : v2;
            }
        }

        public double price(double primaryBase, double secondaryBase, double tertiary) {
            return new PriceCalculator(primaryBase, secondaryBase, tertiary).compute();
        }
    }
}
