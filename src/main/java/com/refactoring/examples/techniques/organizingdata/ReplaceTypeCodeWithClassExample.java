package com.refactoring.examples.techniques.organizingdata;

public class ReplaceTypeCodeWithClassExample {

    public static String getDescription() {
        return "Replace Type Code with Class: When a class has a numeric type code that doesn't " +
               "affect its behaviour, replace the number with a new class. Using a class instead " +
               "of a raw integer prevents invalid values and allows type-safe usage.";
    }

    public static String getBadCode() {
        return """
                // BAD: Blood type stored as raw int — nothing prevents blood.setType(99)
                class Person {
                    public static final int O  = 0;
                    public static final int A  = 1;
                    public static final int B  = 2;
                    public static final int AB = 3;

                    private int bloodGroup;

                    public void setBloodGroup(int bloodGroup) {
                        this.bloodGroup = bloodGroup;  // accepts any integer!
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: BloodGroup is a class — only valid values exist
                class BloodGroup {
                    public static final BloodGroup O  = new BloodGroup(0);
                    public static final BloodGroup A  = new BloodGroup(1);
                    public static final BloodGroup B  = new BloodGroup(2);
                    public static final BloodGroup AB = new BloodGroup(3);

                    private final int code;
                    private BloodGroup(int code) { this.code = code; }
                    public int getCode() { return code; }
                }

                class Person {
                    private BloodGroup bloodGroup;

                    public void setBloodGroup(BloodGroup bloodGroup) {
                        this.bloodGroup = bloodGroup;  // type-safe!
                    }
                }
                """;
    }

    public static class BadExample {
        public static class Person {
            public static final int O  = 0;
            public static final int A  = 1;
            public static final int B  = 2;
            public static final int AB = 3;

            private int bloodGroup;

            public void setBloodGroup(int bloodGroup) {
                this.bloodGroup = bloodGroup; // no validation
            }

            public int getBloodGroup() { return bloodGroup; }
        }
    }

    public static class GoodExample {
        public static class BloodGroup {
            public static final BloodGroup O  = new BloodGroup(0, "O");
            public static final BloodGroup A  = new BloodGroup(1, "A");
            public static final BloodGroup B  = new BloodGroup(2, "B");
            public static final BloodGroup AB = new BloodGroup(3, "AB");

            private final int    code;
            private final String label;

            private BloodGroup(int code, String label) {
                this.code  = code;
                this.label = label;
            }

            public int    getCode()  { return code; }
            public String getLabel() { return label; }

            @Override public String toString() { return label; }
        }

        public static class Person {
            private BloodGroup bloodGroup;

            public void setBloodGroup(BloodGroup bg) { this.bloodGroup = bg; }
            public BloodGroup getBloodGroup()        { return bloodGroup; }
        }
    }
}
