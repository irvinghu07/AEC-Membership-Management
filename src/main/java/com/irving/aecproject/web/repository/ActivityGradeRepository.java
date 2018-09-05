package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.ActivityGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityGradeRepository extends JpaRepository<ActivityGrade, Long> {
}
