package com.bmstechpro.courseinfo.cli.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* course-info
 * @created 09/26/2022
 * @author Konstantin Staykov
 */

class PluralsightCourseTest {

    @Test
    void durationInMinutes() {
        PluralsightCourse pluralsightCourse =
                new PluralsightCourse("id", "Test course","00:05:37","url",false);
        assertEquals(5,pluralsightCourse.durationInMinutes());
    }

    @Test
    void durationInMinutesOverAnHour() {
        PluralsightCourse pluralsightCourse =
                new PluralsightCourse("id", "Test course","01:08:54.9613330","url",false);
        assertEquals(68,pluralsightCourse.durationInMinutes());
    }

    @Test
    void durationInMinutesZero() {
        PluralsightCourse pluralsightCourse =
                new PluralsightCourse("id", "Test course","00:00:00","url",false);
        assertEquals(0,pluralsightCourse.durationInMinutes());
    }
}