package com.boco.schedulethread;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class ScheduleService {

    private static final Logger logger= LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    private SourceCmsService sourceCmsService;
    @Autowired
    private TargetCmsService targetCmsService;

    private boolean flag=false;

    @Scheduled(cron = "0/5 * * * * ?")// corn语句 没3秒调用一次
    @Async
    public void GetDevStatusCheck() {
        try {//加在程序启动后执行
            if(!flag) {
                System.out.println("程序启动后执行");
                if (gatherdataChange().equals("情报板数据转换完成")) {
                    System.out.println("情报板数据转换完毕");
                    flag = true;
                } else
                    System.out.println("情报板数据转换失败");
            }
        } catch (Exception ex) {
            logger.error("GetDevStatusCheck处理异常！");
        }
    }

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

        return result;
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




}
