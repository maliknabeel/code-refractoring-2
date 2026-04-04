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
}
