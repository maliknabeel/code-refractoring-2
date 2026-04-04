package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ReplaceInheritanceWithDelegationExample.*;

public class ReplaceInheritanceWithDelegationExampleGoodExample {
    // MyStack delegates to a list — only exposes stack operations
    public static class MyStack<T> {
        private final java.util.Deque<T> storage = new java.util.ArrayDeque<>();

        public void  push(T item)  { storage.push(item); }
        public T     pop()         { return storage.pop(); }
        public T     peek()        { return storage.peek(); }
        public boolean isEmpty()   { return storage.isEmpty(); }
        public int   size()        { return storage.size(); }
        // No set(index, item) — stack protocol enforced via composition
    }
}
