package com.udemy.backendninja.converter;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {

    //Transforma de una Entity --> Model
    public CourseModel entity2Model(Course course){
        CourseModel courseModel = new CourseModel();
        courseModel.setId(course.getId());
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());
        return courseModel;
    }

    // Transforma de un Model --> Entity
    public Course model2Entity(CourseModel courseModel){
        Course course = new Course();
        course.setId(courseModel.getId());
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        return course;
    }
}
