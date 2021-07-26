package com.sise.utils;

import com.baomidou.mybatisplus.extension.api.R;

public class RUtil {

    public R getInstance(long code, Object data, String msg){
        return new R().setCode(code).setData(data).setMsg(msg);
    }
}
