package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.AssignmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentInfoRepository extends JpaRepository<AssignmentInfo, Long> {
}
