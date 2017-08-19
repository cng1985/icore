package com.ada.approve.listener;

import com.ada.approve.entity.Flow;

public interface OnStateChange {
	
	void change(Flow flow, String state);

}
