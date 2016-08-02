package com.ada.approve.listener;

import java.io.IOException;

import com.ada.approve.entity.Flow;
import com.young.http.Connection.Method;
import com.young.http.HttpConnection;

public class HttpStateChange implements OnStateChange {

	@Override
	public void change(Flow flow, String state) {

		for (int i = 0; i < 3; i++) {
			try {
				if (flow.getFlow().getStateurl() == null) {
					return;
				}
				HttpConnection.connect(flow.getFlow().getStateurl()).data("state", state).data("id", "" + flow.getOid())
						.method(Method.POST).execute().body();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
