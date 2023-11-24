package com.plrs.courseinfo.domain;

import org.junit.jupiter.api.Test;

import static com.plrs.courseinfo.domain.Course.filled;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void filled_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            filled(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            filled("");
        });
    }

}