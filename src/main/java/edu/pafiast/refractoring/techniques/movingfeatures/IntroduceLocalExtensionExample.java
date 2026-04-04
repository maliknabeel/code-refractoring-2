package edu.pafiast.refractoring.techniques.movingfeatures;

public class IntroduceLocalExtensionExample {

    public static String getDescription() {
        return "Introduce Local Extension: When a server class needs several additional methods " +
               "but you can't modify the class, create a new class (subclass or wrapper) that " +
               "contains the extra methods. This is a stronger alternative to Introduce Foreign " +
               "Method when you need to add many methods to a class you cannot change.";
    }

    public static String getBadCode() {
        return """
                // BAD: Multiple foreign methods scattered in client code, not organized
                class Client {
                    // Foreign method 1 - duplicated across the codebase
                    Date nextDay(Date d) { ... }
                    // Foreign method 2 - duplicated
                    Date nextWeek(Date d) { ... }
                    // Foreign method 3 - duplicated
                    boolean isSaturday(Date d) { ... }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: MfDate extends/wraps Date and bundles all extra methods in one place
                class MfDate {
                    private final int year, month, day;

                    public MfDate(int year, int month, int day) {
                        this.year = year; this.month = month; this.day = day;
                    }

                    MfDate nextDay()  { return new MfDate(year, month, day + 1); }
                    MfDate nextWeek() { return new MfDate(year, month, day + 7); }
                    boolean isSaturday() { /* day-of-week calculation */ }
                    String format() { return year + "-" + month + "-" + day; }
                }
                """;
    }
}
