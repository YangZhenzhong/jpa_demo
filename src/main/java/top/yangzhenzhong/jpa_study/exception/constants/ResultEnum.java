package top.yangzhenzhong.jpa_study.exception.constants;

public enum ResultEnum {
    SUCCESS("200","成功"),
    EXCEPTION("500","内部服务器异常"),;
    public final String code;
    public final String msg;

    ResultEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
