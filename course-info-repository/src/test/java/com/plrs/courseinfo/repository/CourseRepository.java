package com.plrs.courseinfo.repository;

import com.plrs.courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    List<Course> getAllCourses();
}
