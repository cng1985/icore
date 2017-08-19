package com.ada.user.oauth;

import com.ada.user.entity.UserQQ;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;

import java.io.IOException;

/**
 * Created by ada on 2017/6/29.
 */
public class QqOauthHander {

    public UserQQ login(String access_token, String openid, String oauth_consumer_key) {
        Connection con = HttpConnection.connect("https://graph.qq.com/user/get_user_info");
        con.data("oauth_consumer_key", oauth_consumer_key);
        con.data("access_token", access_token);
        con.data("openid", openid);
        con.data("format", "json");
        String body = "";
        try {
            body = con.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser parser = new JsonParser();
        JsonElement e = parser.parse(body);
        if (e.getAsJsonObject().get("ret").getAsInt() != 0) {
            return null;
        }

        Gson gson = new Gson();
        UserQQ qq = gson.fromJson(body, UserQQ.class);
        if (qq != null && qq.getRet() != null && qq.getRet() == 0) {
            qq.setOpenid(openid);
        }
        return qq;

    }
}
