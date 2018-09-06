/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: BaseRestResult.java
 * Author:   jiangkun
 * Date:     2018/9/5 13:40
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.rest;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface BaseRestResult<T> {

    String getCode();

    void setCode(String code);

    String getMsg();

    void setMsg(String msg);

    boolean isSuccess();

    T getResult();

    void setResult(T result);

    String getCsrfParameterName();

    void setCsrfParameterName(String csrfParameterName);

    String getCsrfToken();

    void setCsrfToken(String csrfToken);

    String getCsrfHeaderName();

    void setCsrfHeaderName(String csrfHeaderName);

}
