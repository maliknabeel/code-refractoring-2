package com.refactoring.examples.techniques.organizingdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncapsulateCollectionExample {

    public static String getDescription() {
        return "Encapsulate Collection: When a method returns a collection, make it return a " +
               "read-only view and provide add/remove methods. If you return the live collection, " +
               "callers can add/remove elements behind the owner's back, violating encapsulation.";
    }

    public static String getBadCode() {
        return """
                // BAD: getCourses() exposes the live list — anyone can mutate it directly
                class Person {
                    private List<Course> courses = new ArrayList<>();

                    List<Course> getCourses() { return courses; }    // returns live list!
                    void setCourses(List<Course> courses) {           // replaces entire list!
                        this.courses = courses;
                    }
                }

                // External code can do:
                person.getCourses().clear();   // oops — wiped all courses!
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Controlled mutation through add/remove; read-only view returned
                class Person {
                    private List<Course> courses = new ArrayList<>();

                    List<Course> getCourses() {
                        return Collections.unmodifiableList(courses);  // read-only view
                    }

                    void addCourse(Course course) {
                        courses.add(course);
                    }

                    void removeCourse(Course course) {
                        courses.remove(course);
                    }
                }
                """;
    }

    public static class Course {
        private final String name;
        public Course(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class BadExample {
        public static class Person {
            private List<Course> courses = new ArrayList<>();

            public List<Course> getCourses() { return courses; } // exposes live list

            public void setCourses(List<Course> courses) { this.courses = courses; }
        }
    }

    public static class GoodExample {
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
}
