package edu.pafiast.refractoring.techniques.simplifyingconditionals;

public class ReplaceNestedConditionalExample {

    public static String getDescription() {
        return "Replace Nested Conditional with Guard Clauses: When a method has conditional " +
               "behaviour that does not make clear what the normal path of execution is, use " +
               "guard clauses for all the special cases. Guard clauses handle edge cases early " +
               "and let the main flow be obvious at the bottom.";
    }

    public static String getBadCode() {
        return """
                // BAD: Deeply nested — the normal path is buried inside multiple ifs
                double getPayAmount(Employee e) {
                    double result;
                    if (e.isDead) {
                        result = deadAmount();
                    } else {
                        if (e.isSeparated) {
                            result = separatedAmount();
                        } else {
                            if (e.isRetired) {
                                result = retiredAmount();
                            } else {
                                result = normalPayAmount();  // buried!
                            }
                        }
                    }
                    return result;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Guard clauses handle edge cases early; normal path is at the bottom
                double getPayAmount(Employee e) {
                    if (e.isDead)      return deadAmount();       // guard
                    if (e.isSeparated) return separatedAmount();  // guard
                    if (e.isRetired)   return retiredAmount();    // guard
                    return normalPayAmount();                      // main path — obvious!
                }
                """;
    }

    public static class Employee {
        public boolean isDead;
        public boolean isSeparated;
        public boolean isRetired;

        public Employee(boolean isDead, boolean isSeparated, boolean isRetired) {
            this.isDead = isDead;
            this.isSeparated = isSeparated;
            this.isRetired = isRetired;
        }
    }
}
