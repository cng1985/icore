package com.ada.user.rest.api;

import com.ada.user.dto.UserDto;

public interface UserDtoApi {

	public UserDto findByName(String username,String phone);
}
