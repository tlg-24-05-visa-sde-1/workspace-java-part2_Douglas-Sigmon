/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.person.client;

import java.util.HashSet;
import java.util.Set;
import com.person.Person;

public class PersonTestHashCode {
    public static void main(String[] args) {
        Person p1 = new Person("Rob", 33);
        Person p2 = new Person("Rob", 33);
        Person p3 = new Person("Ron", 21);

        // contract: equal objects must have equal hash codes
        // "different" objects should have different hashcodes (but may not - called a 'hash collision')
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());
    }
}