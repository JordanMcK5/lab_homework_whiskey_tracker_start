package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByAgeGreaterThan(int year);

//    List<Whisky> findWhiskyFromDistilleryWithSpecificAge (int age,Long distilleryID);

    List<Whisky> findByDistilleryNameAndAge(String name, int age);


}
