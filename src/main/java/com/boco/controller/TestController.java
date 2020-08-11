package com.boco.controller;

import cms.entity.CMSWordParam;
import cms.entity.CmsProtocalEntity;
import com.boco.cmsprotocolBody.ItemList;
import com.boco.cmsprotocolBody.PlayList;
import com.boco.cmsprotocolBody.WordList;
import com.boco.domain.CjxtGatherDataChr;
import com.boco.service.SourceCmsService;
import com.boco.service.TargetCmsService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
public class TestController {
    @Autowired
    private SourceCmsService sourceCmsService;
    @Autowired
    private TargetCmsService targetCmsService;

    @RequestMapping("/gatherdataChange")
    @ResponseBody
    public String gatherdataChange(){
        String result="";
        targetCmsService.deleteGatherDataChr();
        List<CjxtGatherDataChr> listold= sourceCmsService.getAllGatherDataChr();
        List<CmsProtocalEntity> cmsProtocalEntityList;
        String jsonstr="";
        try {
            for (CjxtGatherDataChr gatherDataChr : listold) {
                cmsProtocalEntityList = this.cmsProtocalJson2Entity(gatherDataChr.getData());
                CjxtGatherDataChr cjxtGatherDataChr=new CjxtGatherDataChr();
                cjxtGatherDataChr.setOrgId(gatherDataChr.getOrgId());
                cjxtGatherDataChr.setDeviceVarTypeId(gatherDataChr.getDeviceVarTypeId());
                cjxtGatherDataChr.setDeviceId(gatherDataChr.getDeviceId());
                cjxtGatherDataChr.setSendFlag(gatherDataChr.getSendFlag());
                cjxtGatherDataChr.setGatherTime(gatherDataChr.getGatherTime());

                PlayList playListValue = new PlayList();
                List<ItemList> itemLists = new ArrayList<>();
                for (CmsProtocalEntity entity : cmsProtocalEntityList) {

                    playListValue.setDpw(entity.getDisplayWidth());
                    playListValue.setDph(entity.getDisplayHeight());
                    playListValue.setDpt(entity.getDispScrType());
                    ItemList itemList = getItemLists(entity);
                    itemLists.add(itemList);
                }

                playListValue.setItemList(itemLists);
                JSONObject object = JSONObject.fromObject(playListValue);
                jsonstr = object.toString();
                cjxtGatherDataChr.setData(jsonstr);
                result=insertjkptcjxtgatherdatachr(cjxtGatherDataChr);
            }
            result="情报板数据转换完成";
        } catch (Exception e) {
            e.printStackTrace();
            result="gatherdataChange 处理数据异常";
        }

        return result;//List2Json(listold);
    }

    public String insertjkptcjxtgatherdatachr(CjxtGatherDataChr cjxtGatherDataChr)
    {
        String result="";
        try{
            targetCmsService.insertjkptcjxtgatherdatachr(cjxtGatherDataChr);
        } catch (Exception e) {
            result="insertjkptcjxtgatherdatachr异常";
        }
        return result;
    }

    public ItemList getItemLists(CmsProtocalEntity entity){
        ItemList itemList=new ItemList();
        try {
            Integer delay=entity.getTimeDelay();
            Integer transition=entity.getTransition();
            List<CMSWordParam> CMSWordParamList=entity.getWordList();

            List<WordList> wordLists=new ArrayList<>();
            String FontName="";
            Integer FontSize=0;
            String FontColor="";
            for(CMSWordParam cmsWordParam :CMSWordParamList ){
                FontName=cmsWordParam.getFontName();
                FontSize=cmsWordParam.getFontSize_HH();
                FontColor=cmsWordParam.getFontColor();
                WordList wordList=new WordList();
                wordList.setWx(cmsWordParam.getWordXXX());
                wordList.setWy(cmsWordParam.getWordYYY());
                wordList.setWc(cmsWordParam.getWordContent());
                wordLists.add(wordList);
            }
            itemList.setDelay(delay);
            itemList.setMode(transition);
            itemList.setFn(FontName);
            itemList.setFs(FontSize);
            itemList.setFc(hexColor2RGB(FontColor));
            itemList.setWordList(wordLists);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemList;
    }

    /**
     * 将16进制颜色值转换为红r 绿g 黄 y
     * @return
     */
    private String hexColor2RGB(String hex) {
        String result = "";

        switch (hex){
            case "ff0000":result="r";
            case "00ff00":result="g";
            case "ffff00":result="y";
            default:result="y";
        }
        return result;
    }

    /**
     * 将通用播放表协议的json串转换为实体对象
     */
    public List<CmsProtocalEntity> cmsProtocalJson2Entity(String protocalJson) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, CmsProtocalEntity.class);
        List<CmsProtocalEntity> list = objectMapper.readValue(protocalJson, javaType);
        return list;
    }

    public static JSONArray List2Json(List<CjxtGatherDataChr> list){
        JSONArray json = JSONArray.fromObject(list);
        return json;
    }


    @RequestMapping("/hi")
    @ResponseBody
    public String hi(){
//        JkptTxxtIssueLog jkptTxxtIssueLog=new JkptTxxtIssueLog();
//        jkptTxxtIssueLog.setOrgId(20300);
//        jkptTxxtIssueLog.setDeviceId(22210001);
//        jkptTxxtIssueLog.setDeviceTypeId(2221);
//        jkptTxxtIssueLog.setDevVarTypeId(222101);
//        //jkptTxxtIssueLog.setIssueInfo("{\"dph\":64,\"dpt\":1,\"dpw\":128,\"itemlist\":[{\"delay\":3,\"fc\":\"r\",\"fn\":\"s\",\"fs\":32,\"graphList\":[],\"mode\":1,\"wordList\":[{\"wc\":\"安全驾驶\",\"wx\":0,\"wy\":0},{\"wc\":\"平安回家\",\"wx\":0,\"wy\":32}]},{\"delay\":3,\"fc\":\"r\",\"fn\":\"s\",\"fs\":32,\"graphList\":[],\"mode\":1,\"wordList\":[{\"wc\":\"路途漫漫\",\"wx\":0,\"wy\":0},{\"wc\":\"文明相伴\",\"wx\":0,\"wy\":32}]}]}");
//        jkptTxxtIssueLog.setIssueInfo("play.lst");
//        jkptTxxtIssueLog.setIssueWordContent("测试");
//        jkptTxxtIssueLog.setOperatFlag("1");
//        jkptTxxtIssueLog.setOperatorId("333344");
//        jkptTxxtIssueLog.setControlDate("2020-05-20 11:11:11");
//        List<JkptTxxtIssueLog> listnew= targetCmsService.getJkptTxxtIssueLog(jkptTxxtIssueLog.getOrgId().toString());
//        int flag= targetCmsService.insertJkptTxxtIssueLog(jkptTxxtIssueLog);
//        String ss="old："+listnew.get(0).getOperatorId().toString();
//
//        List<JkptTxxtIssueLog> listold= sourceCmsService.getJkptTxxtIssueLog(jkptTxxtIssueLog.getOrgId().toString());
//
//        ss+="   new："+listold.get(0).getOperatorId().toString();
        return "good luck：";
//        String curTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        CjxtGatherDataChr cjxtGatherDataChr = new CjxtGatherDataChr();
//        cjxtGatherDataChr.setDeviceid(22210001);
//        cjxtGatherDataChr.setDevicevartypeid(123123);
//        cjxtGatherDataChr.setGathertime(curTime);
//        cjxtGatherDataChr.setData("org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping{property='gathertime', mode=IN, javaType=class java.lang.Object, jdbcType=null, numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: org.apache.ibatis.type.TypeException: Error setting null for parameter #3 with JdbcType OTHER . Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: java.sql.SQLException: 无效的列类型: 1111");
//        cjxtGatherDataChr.setSendflag(1);
//        int flag1 = cmsService.insertCjxtGatherDataChr(cjxtGatherDataChr);
//        if (flag1 == 1) System.out.println("数据插入成功！");
//        else System.out.println("数据插入失败！");

        //return "good luck：";
    }
}
