package com.ada.user.vo;

import com.ada.data.rest.domain.AbstractVo;

import java.io.Serializable;

/**
 * @author 陈联高
 * @version 1.01 2017年03月109日
 */
public class UserAccountVo extends AbstractVo {

    private Long id;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccountVo)) return false;

        UserAccountVo that = (UserAccountVo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
