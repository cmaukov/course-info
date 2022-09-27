package com.bmstechpro.courseinfo.cli.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/* course-info
 * @created 09/26/2022
 * @author Konstantin Staykov
 */

class PluralsightCourseTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            01:08:54.9613330,68
            00:05:37,5
            00:00:00,0
            """)
    void durationInMinutes(String input, long expected) {
        PluralsightCourse pluralsightCourse =
                new PluralsightCourse("id", "Test course",input,"url",false);
        assertEquals(expected,pluralsightCourse.durationInMinutes());
    }


}