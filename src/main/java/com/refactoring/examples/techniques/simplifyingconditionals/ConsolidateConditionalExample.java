package com.refactoring.examples.techniques.simplifyingconditionals;

public class ConsolidateConditionalExample {

    public static String getDescription() {
        return "Consolidate Conditional Expression: When you have a sequence of conditional tests " +
               "with the same result, combine them into a single conditional expression and " +
               "extract it. Multiple separate checks that all return the same thing are really " +
               "one logical check and should be expressed as one.";
    }

    public static String getBadCode() {
        return """
                // BAD: Three separate ifs all return the same thing — really one condition
                double disabilityAmount(Employee e) {
                    if (e.seniority < 2)           return 0;
                    if (e.monthsDisabled > 12)     return 0;
                    if (e.isPartTime)              return 0;
                    // ... actual calculation
                    return calculateDisability(e);
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: All guards consolidated into one named method
                double disabilityAmount(Employee e) {
                    if (isNotEligibleForDisability(e)) return 0;
                    return calculateDisability(e);
                }

                private boolean isNotEligibleForDisability(Employee e) {
                    return e.seniority < 2
                        || e.monthsDisabled > 12
                        || e.isPartTime;
                }
                """;
    }

    public static class Employee {
        int     seniority;
        int     monthsDisabled;
        boolean isPartTime;
        double  baseSalary;

        public Employee(int seniority, int monthsDisabled, boolean isPartTime, double baseSalary) {
            this.seniority = seniority;
            this.monthsDisabled = monthsDisabled;
            this.isPartTime = isPartTime;
            this.baseSalary = baseSalary;
        }
    }

    public static class BadExample {
        public double disabilityAmount(Employee e) {
            if (e.seniority < 2)        return 0;
            if (e.monthsDisabled > 12)  return 0;
            if (e.isPartTime)           return 0;
            return e.baseSalary * 0.6;
        }
    }

    public static class GoodExample {
        private boolean isNotEligibleForDisability(Employee e) {
            return e.seniority < 2 || e.monthsDisabled > 12 || e.isPartTime;
        }

        public double disabilityAmount(Employee e) {
            if (isNotEligibleForDisability(e)) return 0;
            return e.baseSalary * 0.6;
        }
    }
}
