package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

//    public abstract Course findByPrice(int price); // Esta es una Query que automáticamente busca por precio
//    public abstract Course findByPriceAndName(int price, String name); // Busca por precio y nombre
//    public abstract List<Course> findByNameOrderByHours(String name); //Busca por Nombre ordenado por Horas
//    public abstract Course findByNameOrPrice(String name, int price); // Por nombre o precio
}
