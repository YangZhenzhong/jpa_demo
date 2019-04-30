package top.yangzhenzhong.jpa_study.exception;

import top.yangzhenzhong.jpa_study.exception.constants.ResultEnum;

public class BizException extends RuntimeException {
    private static String TIP_HEAD = "业务处理出现异常";
    private String code = ResultEnum.EXCEPTION.code;
    private String msg = ResultEnum.EXCEPTION.msg;
    public BizException() {
        super(TIP_HEAD);
        this.code = ResultEnum.EXCEPTION.code;
        this.msg = ResultEnum.EXCEPTION.msg;
    }

    public BizException( String message ) {
        super(TIP_HEAD + " - " + message);
        this.code = ResultEnum.EXCEPTION.code;
        this.msg = ResultEnum.EXCEPTION.msg;
    }

    public BizException( String code, String msg ) {
        super(TIP_HEAD + " - " + code + ":" + msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException( ResultEnum returnCodeEnum ) {
        this(returnCodeEnum.code, returnCodeEnum.msg);
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
