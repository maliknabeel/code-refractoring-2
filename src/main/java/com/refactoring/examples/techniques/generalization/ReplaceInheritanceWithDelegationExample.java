package com.refactoring.examples.techniques.generalization;

public class ReplaceInheritanceWithDelegationExample {

    public static String getDescription() {
        return "Replace Inheritance with Delegation: When a subclass uses only part of a " +
               "superclasses interface, or does not want to inherit data, create a field for " +
               "the superclass, adjust methods to delegate to the superclass, and remove the " +
               "subclassing. Favour composition over inheritance when the IS-A relationship " +
               "doesn't hold.";
    }

    public static String getBadCode() {
        return """
                // BAD: Stack extends Vector — a Stack IS NOT a Vector!
                //      Stack inherits add(index, element), contains(), etc. which violate stack semantics
                class Stack<T> extends java.util.Vector<T> {
                    T push(T item) { addElement(item); return item; }
                    T pop()        { T last = lastElement(); removeElementAt(size()-1); return last; }
                    // But now callers can also call stack.add(0, item) — bypassing stack protocol!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Stack delegates to a Vector field — only stack operations exposed
                class Stack<T> {
                    private java.util.Vector<T> storage = new java.util.Vector<>();

                    void push(T item) { storage.addElement(item); }
                    T    pop()        {
                        T last = storage.lastElement();
                        storage.removeElementAt(storage.size() - 1);
                        return last;
                    }
                    boolean isEmpty() { return storage.isEmpty(); }
                    int     size()    { return storage.size(); }
                    // No add(index, element) — stack protocol enforced
                }
                """;
    }
}
