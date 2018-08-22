package com.irving.aecproject.web.dao;

import com.irving.aecproject.web.entity.ScoreRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRecordMapper {
    int deleteByPrimaryKey(Integer recordid);

    int insert(ScoreRecord record);

    ScoreRecord selectByPrimaryKey(Integer recordid);

    List<ScoreRecord> selectAll();

    int updateByPrimaryKey(ScoreRecord record);
}