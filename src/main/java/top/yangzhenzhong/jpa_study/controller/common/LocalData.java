package top.yangzhenzhong.jpa_study.controller.common;

/**
 * @author guoyankui
 * @date 2018/7/20 1:33 PM
 * @description
 */
public class LocalData {

    public static final ThreadLocal<String> TXID = new ThreadLocal<>();

}
