package com.sj.boot.modules.sys.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceMatch {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String faceMatch() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            HashMap<String, String> map = new HashMap<>();

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createUserGroup() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/add";
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("group_id","cassi123");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = ImageAuthUtils.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createFaceset() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            HashMap<String, String> map = new HashMap<>();

            map.put("group_id","cassi123");

            String base64 = Base64Util.fileToBase64("C:\\Users\\86176\\Pictures\\test.jpg");
            map.put("image",base64);
            map.put("image_type","BASE64");
            map.put("group_id","cassi123");
            map.put("user_id","muzhijun_123");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = ImageAuthUtils.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String faceSerach() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            HashMap<String, String> map = new HashMap<>();

            // map.put("group_id","cassi123");

            String base64 = Base64Util.fileToBase64("C:\\Users\\86176\\Pictures\\test.jpg");
            map.put("image",base64);
            map.put("image_type","BASE64");
            map.put("group_id_list","cassi123");
            // map.put("user_id","muzhijun_123");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = ImageAuthUtils.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);


            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String result = FaceMatch.faceSerach();
        if (!StringUtils.isEmpty(result)){
            Map o = GsonUtils.fromJson(result, Map.class);
            Map<String, Object> result1 = (Map<String, Object>)o.get("result");
            System.out.println(result1);
            if (result1 != null){
                List<Map<String, Object>> userList = (List<Map<String, Object>>) result1.get("user_list");
                if (userList != null && userList.size() > 0){
                    Map<String, Object> stringObjectMap = userList.get(0);
                    Double score = (Double)stringObjectMap.get("score");
                    System.out.println(score);
                }
            }
        }
    }
}
