package com.ada.user.oauth;

import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ada on 2017/6/29.
 */
public class WeiXinOauthHander {
    /**
     * @param element
     * @return
     */
    private String getString(JsonElement element, String key) {

        String result = "";
        try {
            result = element.getAsJsonObject().get(key).getAsString();
        } catch (Exception e2) {
        }

        return result;
    }

    private Integer getInt(JsonElement element, String key) {

        Integer result = 0;
        try {
            result = element.getAsJsonObject().get(key).getAsInt();
        } catch (Exception e2) {
        }
        return result;
    }
    public UserWeiXin login(String access_token, String openid, String oauth_consumer_key) {
        UserWeiXin weixin=null;
        try {
            Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/userinfo");
            con.data("access_token", access_token);
            con.data("openid", openid);
            String body;
            body = con.execute().body();

             weixin = new UserWeiXin();
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(body);
            String nickname = getString(element, "nickname");
            weixin.setNickName(nickname);
            String headimgurl = getString(element, "headimgurl");
            weixin.setHeadimgurl(headimgurl);
            String city = getString(element, "city");
            weixin.setCity(city);
            Integer sexid = getInt(element, "sex");
            String sex = "男";
            if (sexid == null || sexid == 0) {
                sex = "女";
            }
            weixin.setSex(sex);
            String province = getString(element, "province");
            weixin.setProvince(province);
            String country = getString(element, "country");
            weixin.setCountry(country);
            weixin.setUnionid(getString(element, "unionid"));
            weixin.setAccessToken(access_token);
            weixin.setOpenid(openid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return weixin;

    }
}
