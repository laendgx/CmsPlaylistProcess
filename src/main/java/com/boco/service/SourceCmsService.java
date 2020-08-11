package com.boco.service;

import com.boco.domain.CjxtGatherDataChr;
import com.boco.domain.JkptTxxtIssueLog;
import com.boco.sourcemapper.SourceCmsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SourceCmsService {
    @Autowired
    private SourceCmsMapper sourceCmsMapper;

    private static final Logger logger= LoggerFactory.getLogger(SourceCmsService.class);

    public List<CjxtGatherDataChr> getAllGatherDataChr() {
        List<CjxtGatherDataChr> CjxtGatherDataChrs=new ArrayList<>();
        try{
            CjxtGatherDataChrs = sourceCmsMapper.getAllGatherDataChr();
        } catch (Exception e) {
            logger.error("getJkptTxxtIssueLog数据转发异常"+e.toString());
        }
        return CjxtGatherDataChrs;
    }

}
