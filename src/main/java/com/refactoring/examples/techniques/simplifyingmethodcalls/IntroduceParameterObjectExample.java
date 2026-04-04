package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class IntroduceParameterObjectExample {

    public static String getDescription() {
        return "Introduce Parameter Object: When you have a group of parameters that naturally " +
               "go together, replace them with an object. This reduces parameter lists, creates " +
               "a home for behaviour that manipulates this data, and makes the code more " +
               "expressive.";
    }

    public static String getBadCode() {
        return """
                // BAD: start/end date parameters repeated across many methods
                List<Reading> readingsInRange(Date start, Date end) { ... }
                List<Charge>  chargesInRange(Date start, Date end)  { ... }
                double        incomeInRange(Date start, Date end)   { ... }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: DateRange parameter object groups start/end together
                class DateRange {
                    private final Date start;
                    private final Date end;

                    public DateRange(Date start, Date end) { ... }
                    boolean includes(Date date) { return !date.before(start) && !date.after(end); }
                }

                List<Reading> readingsInRange(DateRange range) { ... }
                List<Charge>  chargesInRange(DateRange range)  { ... }
                double        incomeInRange(DateRange range)   { ... }
                """;
    }
}
