package com.refactoring.examples.techniques.organizingdata.good;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.EncapsulateCollectionExample.*;

public class EncapsulateCollectionExampleGoodExample {
    public static class Person {
        private final List<Course> courses = new ArrayList<>();

        public List<Course> getCourses() {
            return Collections.unmodifiableList(courses); // safe view
        }

        public void addCourse(Course course) {
            courses.add(course);
        }

        public boolean removeCourse(Course course) {
            return courses.remove(course);
        }

        public int getCourseCount() { return courses.size(); }
    }
}
