package com.ada.user.template;

import java.util.Map;

public interface NoticePushApi {

	int push(String templateid, Map<String, String> keys, String... channels);

	int pushjodd(String templateid, Map<String, String> keys, String... channels);

}