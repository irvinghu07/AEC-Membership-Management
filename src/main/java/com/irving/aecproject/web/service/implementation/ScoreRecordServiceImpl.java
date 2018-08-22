package com.irving.aecproject.web.service.implementation;

import com.irving.aecproject.web.dao.ScoreRecordMapper;
import com.irving.aecproject.web.entity.ScoreRecord;
import com.irving.aecproject.web.service.ScoreRecordService;
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
