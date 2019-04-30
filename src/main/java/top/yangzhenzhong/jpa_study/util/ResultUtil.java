package top.yangzhenzhong.jpa_study.util;

import top.yangzhenzhong.jpa_study.controller.common.ResultEntity;

public class ResultUtil {
    public static ResultEntity success(Object obj) {
        ResultEntity ResultEntity = new ResultEntity();
        ResultEntity.setCode("200");
        ResultEntity.setMsg("成功");
        ResultEntity.setData(obj);
        return ResultEntity;
    }

    public static ResultEntity success() {
        ResultEntity ResultEntity = new ResultEntity();
        ResultEntity.setCode("200");
        ResultEntity.setMsg("成功");
        return ResultEntity;
    }

    public static ResultEntity error(String code, String message) {
        ResultEntity ResultEntity = new ResultEntity();
        ResultEntity.setCode(code);
        ResultEntity.setMsg(message);
        return ResultEntity;
    }

}
