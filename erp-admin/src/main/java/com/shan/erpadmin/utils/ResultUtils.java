package com.shan.erpadmin.utils;


import com.shan.erpadmin.domain.Result;

public class ResultUtils {

    /**
     * 请求成功统一处理
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    /**
     * 请求成功统一处理
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
