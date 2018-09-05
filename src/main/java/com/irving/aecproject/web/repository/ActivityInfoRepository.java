package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.ActivityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityInfoRepository extends JpaRepository<ActivityInfo, Long> {
}
