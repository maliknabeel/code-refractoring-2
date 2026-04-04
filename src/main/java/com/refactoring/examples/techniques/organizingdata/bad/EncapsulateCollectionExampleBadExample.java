package com.refactoring.examples.techniques.organizingdata.bad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.EncapsulateCollectionExample.*;

public class EncapsulateCollectionExampleBadExample {
    public static class Person {
        private List<Course> courses = new ArrayList<>();

        public List<Course> getCourses() { return courses; } // exposes live list

        public void setCourses(List<Course> courses) { this.courses = courses; }
    }
}
