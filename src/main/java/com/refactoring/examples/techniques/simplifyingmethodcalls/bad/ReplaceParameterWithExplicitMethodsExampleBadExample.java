package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceParameterWithExplicitMethodsExample.*;

public class ReplaceParameterWithExplicitMethodsExampleBadExample {
    private int height;
    private int width;

    public void setValue(String type, int amount) {
        if ("height".equals(type))      height = amount;
        else if ("width".equals(type))  width  = amount;
        else throw new IllegalArgumentException("Unknown type: " + type);
    }

    public int getHeight() { return height; }
    public int getWidth()  { return width; }
}
