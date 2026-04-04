package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceParameterWithExplicitMethodsExample.*;

public class ReplaceParameterWithExplicitMethodsExampleGoodExample {
    private int height;
    private int width;

    public void setHeight(int height) { this.height = height; }
    public void setWidth(int width)   { this.width  = width; }

    public int getHeight() { return height; }
    public int getWidth()  { return width; }
}
