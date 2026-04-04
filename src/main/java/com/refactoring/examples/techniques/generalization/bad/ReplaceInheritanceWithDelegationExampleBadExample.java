package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ReplaceInheritanceWithDelegationExample.*;

public class ReplaceInheritanceWithDelegationExampleBadExample {
    // MyStack extends java.util.Vector — wrong! Stack is NOT a Vector
    public static class MyStack<T> extends java.util.Vector<T> {
        public void pushItem(T item) { addElement(item); }
        public T popItem() {
            T last = lastElement();
            removeElementAt(size() - 1);
            return last;
        }
        // Inherits add(0, item), set(index, item) etc. — violates stack abstraction
    }
}
