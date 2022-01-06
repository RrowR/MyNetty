package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * atlan 23:11
 */
public class TestJson {

    @Test
    public void parseToGetJSon(){
        String data = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"msg\": \"SUCCESS\",\n" +
                "    \"data\": {\n" +
                "        \"total\": 2,\n" +
                "        \"pageNo\": 1,\n" +
                "        \"pageSize\": 20,\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"altitude\": null,\n" +
                "                \"cameraIndexCode\": \"d8774c652dad4fb9a3f85c22ff87afa6\",\n" +
                "                \"cameraName\": \"IPC\",\n" +
                "                \"cameraType\": 0,\n" +
                "                \"cameraTypeName\": \"枪机\",\n" +
                "                \"capabilitySet\": null,\n" +
                "                \"capabilitySetName\": null,\n" +
                "                \"intelligentSet\": null,\n" +
                "                \"intelligentSetName\": null,\n" +
                "                \"channelNo\": \"1\",\n" +
                "                \"channelType\": \"analog\",\n" +
                "                \"channelTypeName\": \"模拟通道\",\n" +
                "                \"createTime\": \"2020-11-06T15:59:46.152+08:00\",\n" +
                "                \"encodeDevIndexCode\": \"28d097d8dc5e46ba8dc8d480d8bb5f2b\",\n" +
                "                \"encodeDevResourceType\": null,\n" +
                "                \"encodeDevResourceTypeName\": null,\n" +
                "                \"gbIndexCode\": \"33030400581314001172\",\n" +
                "                \"installLocation\": null,\n" +
                "                \"keyBoardCode\": null,\n" +
                "                \"latitude\": null,\n" +
                "                \"longitude\": null,\n" +
                "                \"pixel\": null,\n" +
                "                \"ptz\": null,\n" +
                "                \"ptzName\": null,\n" +
                "                \"ptzController\": null,\n" +
                "                \"ptzControllerName\": null,\n" +
                "                \"recordLocation\": null,\n" +
                "                \"recordLocationName\": null,\n" +
                "                \"regionIndexCode\": \"d5362b09-a63d-4006-87cd-ccb85b6a7f96\",\n" +
                "                \"status\": null,\n" +
                "                \"statusName\": null,\n" +
                "                \"transType\": 1,\n" +
                "                \"transTypeName\": \"TCP\",\n" +
                "                \"treatyType\": null,\n" +
                "                \"treatyTypeName\": null,\n" +
                "                \"viewshed\": null,\n" +
                "                \"updateTime\": \"2020-11-06T15:59:46.229+08:00\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"altitude\": null,\n" +
                "                \"cameraIndexCode\": \"3dfc0540bfae479fae96498122311fc1\",\n" +
                "                \"cameraName\": \"IPC\",\n" +
                "                \"cameraType\": 0,\n" +
                "                \"cameraTypeName\": \"枪机\",\n" +
                "                \"capabilitySet\": null,\n" +
                "                \"capabilitySetName\": null,\n" +
                "                \"intelligentSet\": null,\n" +
                "                \"intelligentSetName\": null,\n" +
                "                \"channelNo\": \"1\",\n" +
                "                \"channelType\": \"analog\",\n" +
                "                \"channelTypeName\": \"模拟通道\",\n" +
                "                \"createTime\": \"2020-11-06T15:59:46.153+08:00\",\n" +
                "                \"encodeDevIndexCode\": \"36cea7bac60147dcb8a83ff4a4956ae3\",\n" +
                "                \"encodeDevResourceType\": null,\n" +
                "                \"encodeDevResourceTypeName\": null,\n" +
                "                \"gbIndexCode\": \"33030400581314001173\",\n" +
                "                \"installLocation\": null,\n" +
                "                \"keyBoardCode\": null,\n" +
                "                \"latitude\": null,\n" +
                "                \"longitude\": null,\n" +
                "                \"pixel\": null,\n" +
                "                \"ptz\": null,\n" +
                "                \"ptzName\": null,\n" +
                "                \"ptzController\": null,\n" +
                "                \"ptzControllerName\": null,\n" +
                "                \"recordLocation\": null,\n" +
                "                \"recordLocationName\": null,\n" +
                "                \"regionIndexCode\": \"d5362b09-a63d-4006-87cd-ccb85b6a7f96\",\n" +
                "                \"status\": null,\n" +
                "                \"statusName\": null,\n" +
                "                \"transType\": 1,\n" +
                "                \"transTypeName\": \"TCP\",\n" +
                "                \"treatyType\": null,\n" +
                "                \"treatyTypeName\": null,\n" +
                "                \"viewshed\": null,\n" +
                "                \"updateTime\": \"2020-11-06T15:59:46.229+08:00\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(data);
        JSONArray jsonArray = jsonObject
                .getJSONObject("data")
                .getJSONArray("list");


        JSONObject json = (JSONObject) jsonArray.get(0);
        String result = json.getString("regionIndexCode");
        System.out.println(result);
        jsonArray.forEach(o -> {
            Set<Map.Entry<String, Object>> entries = ((JSONObject) o).entrySet();
        });



    }

}
