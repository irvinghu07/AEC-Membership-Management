package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, Long> {
}
