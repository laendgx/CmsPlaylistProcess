package com.boco.targetmapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TargetCmsMapper {
    //删除发布信息
    @Delete("delete from JKPT_CJXT_GATHERDATA_CHR")
    public int deleteGatherDataChr();

    //插入发布信息
    @Insert("insert into jkpt_cjxt_gatherdata_chr(gathertime,sendflag,data,deviceid,devicevartypeid,orgid)" +
            " values(" +
            " to_date(#{gathertime},'yyyy-MM-dd HH24:mi:ss')," +
            " #{sendflag,jdbcType=NUMERIC}," +
            " #{data,jdbcType=VARCHAR}," +
            " #{deviceid,jdbcType=NUMERIC}," +
            " #{devicevartypeid,jdbcType=NUMERIC}," +
            " #{orgid,jdbcType=NUMERIC}" +
            " )")
    public int insertjkptcjxtgatherdatachr(@Param("gathertime") String GATHERTIME,
                                      @Param("sendflag") Integer sendflag,
                                      @Param("data") String data,
                                      @Param("deviceid") Integer deviceid,
                                      @Param("devicevartypeid") Integer devicevartypeid,
                                      @Param("orgid") Integer devicetypeid);
}
