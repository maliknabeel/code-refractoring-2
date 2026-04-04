package com.refactoring.examples.techniques.simplifyingconditionals;

import java.time.LocalDate;

public class DecomposeConditionalExample {

    public static String getDescription() {
        return "Decompose Conditional: When you have a complicated conditional (if-then-else) " +
               "statement, extract methods from the condition, then part, and else part. " +
               "Long conditional logic is hard to understand because it mixes what-to-check " +
               "with what-to-do. Named methods make both intentions clear.";
    }

    public static String getBadCode() {
        return """
                // BAD: Complex inline conditions — why are we checking these? What do they mean?
                double getCharge(LocalDate date, int quantity, Plan plan) {
                    double charge;
                    if (!date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd())) {
                        charge = quantity * plan.summerRate();
                    } else {
                        charge = quantity * plan.winterRate() + plan.winterServiceCharge();
                    }
                    return charge;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Extracted methods make the business intent crystal clear
                double getCharge(LocalDate date, int quantity, Plan plan) {
                    return isSummer(date, plan)
                        ? summerCharge(quantity, plan)
                        : winterCharge(quantity, plan);
                }

                private boolean isSummer(LocalDate date, Plan plan) {
                    return !date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd());
                }

                private double summerCharge(int quantity, Plan plan) {
                    return quantity * plan.summerRate();
                }

                private double winterCharge(int quantity, Plan plan) {
                    return quantity * plan.winterRate() + plan.winterServiceCharge();
                }
                """;
    }

    public static class Plan {
        private final int summerStartMonth;
        private final int summerEndMonth;

        public Plan(int summerStartMonth, int summerEndMonth) {
            this.summerStartMonth = summerStartMonth;
            this.summerEndMonth   = summerEndMonth;
        }

        public LocalDate summerStart()     { return LocalDate.of(LocalDate.now().getYear(), summerStartMonth, 1); }
        public LocalDate summerEnd()       { return LocalDate.of(LocalDate.now().getYear(), summerEndMonth, 30); }
        public double    summerRate()      { return 1.5; }
        public double    winterRate()      { return 2.0; }
        public double    winterServiceCharge() { return 10.0; }
    }
}
