package com.udemy.backendninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    // Clic derecho nombre del Proyecto > Maven > Download Sources
    private QCourse qCourse = QCourse.course;

    //EntityManager: se encarga de gestionar las entidades de la Persistencia de la app
    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exist){
        //Es necesario hacer esto siempre para crear la query:
        JPAQuery<Course> query = new JPAQuery<Course>(em);

        // Para hacer una clausula 'where' dinámica. Busca los courses con terminación OP en la descripcion y si
        // exist == true; where id=23 (tambien), sino where la terminación de name="OP"
        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
        if (exist){
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        }else{
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }


        /* CONSULTAS QUERYDSL: .select((los-campos-que-queremos))
                                .from((la-tabla))
                                .where((la-condición))
        */
        //fetchOne nos trae el Curso con id=23
//        Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
//        Course course1 = (Course) query.select(qCourse.name,qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

        // fetch = "trainos el listado"
//        List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,50)).fetch();

        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
    }
}
