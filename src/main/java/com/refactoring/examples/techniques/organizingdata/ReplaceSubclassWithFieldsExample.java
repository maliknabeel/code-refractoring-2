package com.refactoring.examples.techniques.organizingdata;

public class ReplaceSubclassWithFieldsExample {

    public static String getDescription() {
        return "Replace Subclass with Fields: When you have subclasses that differ only in methods " +
               "that return constant data, change the methods to fields in the superclass and " +
               "eliminate the subclasses. Creating subclasses just for constant values is overkill.";
    }

    public static String getBadCode() {
        return """
                // BAD: Subclasses exist only to return different constant values
                abstract class Person {
                    abstract boolean isMale();
                    abstract char getCode();
                }

                class Male extends Person {
                    boolean isMale() { return true; }
                    char    getCode() { return 'M'; }
                }

                class Female extends Person {
                    boolean isMale() { return false; }
                    char    getCode() { return 'F'; }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Constants become fields; subclasses eliminated
                class Person {
                    private final boolean isMale;
                    private final char    code;

                    static Person createMale()   { return new Person(true,  'M'); }
                    static Person createFemale() { return new Person(false, 'F'); }

                    private Person(boolean isMale, char code) {
                        this.isMale = isMale;
                        this.code   = code;
                    }

                    boolean isMale() { return isMale; }
                    char    getCode() { return code; }
                }
                """;
    }

    public static class BadExample {
        abstract public static class Person {
            abstract boolean isMale();
            abstract char    getCode();
            abstract String  getLabel();
        }

        public static class Male extends Person {
            @Override boolean isMale()  { return true; }
            @Override char    getCode() { return 'M'; }
            @Override String  getLabel(){ return "Male"; }
        }

        public static class Female extends Person {
            @Override boolean isMale()  { return false; }
            @Override char    getCode() { return 'F'; }
            @Override String  getLabel(){ return "Female"; }
        }
    }

    public static class GoodExample {
        public static class Person {
            private final boolean isMale;
            private final char    code;
            private final String  label;

            public static Person createMale()   { return new Person(true,  'M', "Male"); }
            public static Person createFemale() { return new Person(false, 'F', "Female"); }

            private Person(boolean isMale, char code, String label) {
                this.isMale = isMale;
                this.code   = code;
                this.label  = label;
            }

            public boolean isMale()  { return isMale; }
            public char    getCode() { return code; }
            public String  getLabel(){ return label; }
        }
    }
}
