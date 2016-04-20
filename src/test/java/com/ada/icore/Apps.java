package com.ada.icore;

import java.io.IOException;

import com.young.http.Connection;
import com.young.http.Connection.Method;
import com.young.http.HttpConnection;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = HttpConnection.connect("http://www.oschina.net/action/openapi/token").method(Method.GET);
		String client_id = "CTJlkYcnBaZCsi4GGgUk";
		String client_secret = "TlKrmPCKImAKEzk1ORZtdwooJKDIgXrF";
		String grant_type = "authorization_code";
		String redirect_uri = "http://www.yichisancun.com/qqoschina.htm";
		String code = "TjVcfj&state=";

		con.data("client_id", client_id);
		con.data("client_secret", client_secret);
		con.data("grant_type", grant_type);
		con.data("redirect_uri", redirect_uri);
		con.data("code", code);
		con.data("dataType", "json");
		try {
			String body = con.execute().body();
			System.out.println(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
