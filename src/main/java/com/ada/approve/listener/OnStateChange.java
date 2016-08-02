package com.ada.approve.listener;

import com.ada.approve.entity.Flow;

public interface OnStateChange {
	
	public void change(Flow flow,String state);

}
