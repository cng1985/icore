package com.ada.user.template;

import java.util.Map;

public interface NoticePushApi {

	int push(String templateid, Map<String, String> keys, Map<String, String> pushkeys, String... channels);

	int pushjodd(String templateid, Map<String, String> keys, Map<String, String> pushkeys, String... channels);

	
	int pushToTag(String templateid, Map<String, String> keys, Map<String, String> pushkeys, String... tags);

	
}