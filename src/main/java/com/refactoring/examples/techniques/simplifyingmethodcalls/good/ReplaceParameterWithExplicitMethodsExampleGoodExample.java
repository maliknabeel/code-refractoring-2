package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceParameterWithExplicitMethodsExample.*;

public class ReplaceParameterWithExplicitMethodsExampleGoodExample {
    private int height;
    private int width;

    public void setHeight(int height) { this.height = height; }
    public void setWidth(int width)   { this.width  = width; }

    public int getHeight() { return height; }
    public int getWidth()  { return width; }
}
