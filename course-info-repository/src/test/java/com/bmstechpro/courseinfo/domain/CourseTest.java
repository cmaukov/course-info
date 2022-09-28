package com.bmstechpro.courseinfo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

class CourseTest {

    @Test
    void idThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Course(null, "test", 5, "url"));
    }

    @Test
    void nameThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Course("id", null, 5, "url"));

    }

    @Test
    void urlThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Course("id", "test", 5, null));
    }


}