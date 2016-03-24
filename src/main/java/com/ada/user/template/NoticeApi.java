package com.ada.user.template;

import java.util.Map;

public interface NoticeApi {

	int push(String templateid, Map<String, String> keys, Long... users);

	int pushjodd(String templateid, Map<String, String> keys, Long... users);

}