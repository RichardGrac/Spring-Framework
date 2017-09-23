package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository; // Creamos la instancia de la interaface

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @Override
    public List<CourseModel> listAllCourses() {
        LOG.info("Call: listAllCourses()");
        /* Debido a que los Controller deben manejar SOLO MODELOS, hacemos la conversión aquí: */
        List<CourseModel> courseModels = new ArrayList<>();
        for (Course course: courseJpaRepository.findAll()){
            courseModels.add(courseConverter.entity2Model(course));
        }
        return courseModels;
    }

    @Override
    public Course addCourse(CourseModel courseModel) {
        LOG.info("Call: addCourses()");
        // Convertimos del CourseModel(Modelo) a una Entity (Enviandole como parametro la conversión)
        // Guarda en BD y si es correcto nos devuelve el objeto recien guardado
        return courseJpaRepository.save(courseConverter.model2Entity(courseModel));
    }

    @Override
    public int removeCourse(int id) {
        courseJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Course updateCourse(CourseModel courseModel) {
        // Como "course" ya va a tener un id, por lo que al intentar guardalo en la BD solo se actualizará
        System.out.println("Update: " + courseModel.getId());
        return courseJpaRepository.save(courseConverter.model2Entity(courseModel));
    }

    @Override
    public CourseModel getCourse(int id) {
        Course course = courseJpaRepository.findById(id);
        return courseConverter.entity2Model(course);
    }


}
