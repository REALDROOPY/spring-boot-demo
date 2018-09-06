/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: DefaultRestResultImpl.java
 * Author:   jiangkun
 * Date:     2018/9/5 13:41
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.rest;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DefaultRestResultImpl<T> implements BaseRestResult<T> {

    private String code = "0";
    private String msg;
    private String csrfParameterName;
    private String csrfToken;
    private String csrfHeaderName;

    private T result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultRestResultImpl{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", csrfParameterName='").append(csrfParameterName).append('\'');
        sb.append(", csrfToken='").append(csrfToken).append('\'');
        sb.append(", csrfHeaderName='").append(csrfHeaderName).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean isSuccess() {
        return "0".equals(this.code);
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String getCsrfParameterName() {
        return csrfParameterName;
    }

    @Override
    public void setCsrfParameterName(String csrfParameterName) {
        this.csrfParameterName = csrfParameterName;
    }

    @Override
    public String getCsrfToken() {
        return csrfToken;
    }

    @Override
    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    @Override
    public String getCsrfHeaderName() {
        return csrfHeaderName;
    }

    @Override
    public void setCsrfHeaderName(String csrfHeaderName) {
        this.csrfHeaderName = csrfHeaderName;
    }
}
