package com.refactoring.examples.techniques.generalization;

public class CollapseHierarchyExample {

    public static String getDescription() {
        return "Collapse Hierarchy: When a superclass and subclass are not very different, merge " +
               "them together. Sometimes after refactoring a class hierarchy, a subclass shrinks " +
               "to the point where it adds no value — collapse it into its parent.";
    }

    public static String getBadCode() {
        return """
                // BAD: WebSite adds nothing over Party — no new fields, no overrides
                abstract class Party {
                    protected String name;
                    String getName() { return name; }
                }

                class WebSite extends Party {
                    // Completely empty — no new behaviour or fields!
                    // Why does this class exist?
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: WebSite merged into Party (or renamed) — hierarchy collapsed
                class Party {
                    private String name;

                    public Party(String name) { this.name = name; }
                    String getName()   { return name; }
                }
                // WebSite class deleted — its usages now use Party directly
                """;
    }

    public static class BadExample {
        public static class Employee {
            protected String name;
            protected int    grade;
            public Employee(String name, int grade) { this.name = name; this.grade = grade; }
            public String getName()  { return name; }
            public int    getGrade() { return grade; }
        }

        // ActiveEmployee adds nothing — empty subclass
        public static class ActiveEmployee extends Employee {
            public ActiveEmployee(String name, int grade) { super(name, grade); }
            // No new fields, no overrides, no reason to exist
        }
    }

    public static class GoodExample {
        // Hierarchy collapsed — Employee handles everything
        public static class Employee {
            private final String name;
            private final int    grade;

            public Employee(String name, int grade) { this.name = name; this.grade = grade; }
            public String getName()  { return name; }
            public int    getGrade() { return grade; }
        }
    }
}
