package com.bmstechpro.courseinfo.domain;
/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

public record Course(String id, String name, long length, String url) {
    public Course {
        filled(id);
        filled(name);
        filled(url);
    }

    private static void filled(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("No value present!");
        }
    }
}
