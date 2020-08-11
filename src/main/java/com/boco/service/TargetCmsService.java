package com.boco.service;

import com.boco.domain.CjxtGatherDataChr;
import com.boco.domain.JkptTxxtIssueLog;
import com.boco.targetmapper.TargetCmsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TargetCmsService {
    @Autowired
    private TargetCmsMapper TargetCmsMapper;

    private static final Logger logger= LoggerFactory.getLogger(TargetCmsService.class);

    public int  deleteGatherDataChr(){
        int flag=0;
        try{
            flag = TargetCmsMapper.deleteGatherDataChr();
        } catch (Exception e) {
            logger.error("deleteGatherDataChr"+e.toString());
        }
        return flag;
    }

    public int insertjkptcjxtgatherdatachr(CjxtGatherDataChr cjxtGatherDataChr){
        int flag=0;
        try{
            flag = TargetCmsMapper.insertjkptcjxtgatherdatachr(cjxtGatherDataChr.getGatherTime(),cjxtGatherDataChr.getSendFlag()
            ,cjxtGatherDataChr.getData(),cjxtGatherDataChr.getDeviceId(),cjxtGatherDataChr.getDeviceVarTypeId(),cjxtGatherDataChr.getOrgId());
        } catch (Exception e) {
            logger.error("deleteGatherDataChr"+e.toString());
        }
        return flag;
    }

}
