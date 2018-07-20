package com.irving.aecproject.service.implementation;

import com.irving.aecproject.dao.ScoreRecordMapper;
import com.irving.aecproject.entity.ScoreRecord;
import com.irving.aecproject.service.ScoreRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("scoreRecordService")
public class ScoreRecordServiceImpl implements ScoreRecordService
{
    @Resource
    private ScoreRecordMapper scoreRecordMapper;

    @Override
    public List<ScoreRecord> queryAllRecords() {
        return scoreRecordMapper.selectAll();
    }
}
