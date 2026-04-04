package edu.pafiast.refractoring.techniques.organizingdata.bad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.EncapsulateCollectionExample.*;

public class EncapsulateCollectionExampleBadExample {
    public static class Person {
        private List<Course> courses = new ArrayList<>();

        public List<Course> getCourses() { return courses; } // exposes live list

        public void setCourses(List<Course> courses) { this.courses = courses; }
    }
}
