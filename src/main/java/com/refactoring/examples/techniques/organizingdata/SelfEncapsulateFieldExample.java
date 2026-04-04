package com.refactoring.examples.techniques.organizingdata;

public class SelfEncapsulateFieldExample {

    public static String getDescription() {
        return "Self Encapsulate Field: When you access a field directly, create a getter/setter " +
               "for the field and use only those to access it. Even within the class itself, " +
               "accessing through accessors allows subclasses to override the method and " +
               "makes future changes to field access easier.";
    }

    public static String getBadCode() {
        return """
                // BAD: Direct field access — subclasses can't override the access behaviour
                class Range {
                    private int low;
                    private int high;

                    boolean includes(int arg) {
                        return arg >= low && arg <= high;  // direct field access
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Access through getter — subclasses can override getLow()/getHigh()
                class Range {
                    private int low;
                    private int high;

                    protected int getLow()  { return low; }
                    protected int getHigh() { return high; }

                    boolean includes(int arg) {
                        return arg >= getLow() && arg <= getHigh();
                    }
                }

                class CappedRange extends Range {
                    private int cap;
                    @Override protected int getHigh() { return Math.min(super.getHigh(), cap); }
                }
                """;
    }
}
