package com.boco.sourcemapper;

import com.boco.domain.CjxtGatherDataChr;
import com.boco.domain.JkptTxxtIssueLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SourceCmsMapper {
    //获取指定情报板的发布信息
    @Select("select C.ORGID,B.DEVICEID,C.DEVICETYPEID||'01' AS DEVICEVARTYPEID,A.GATHERTIME,A.SENDFLAG,A.DATA " +
            "from JKPT_CJXT_GATHERDATA_CHR A,JKPT_TXXT_DEVICEGATHER B,JKPT_TXXT_DEVICE C " +
            "WHERE A.DEVICEVARID=B.DEVICEVARID AND B.DEVICEID=C.DEVICEID")
    public List<CjxtGatherDataChr> getAllGatherDataChr();
 }
