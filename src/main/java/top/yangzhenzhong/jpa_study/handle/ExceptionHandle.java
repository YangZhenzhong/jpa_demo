package top.yangzhenzhong.jpa_study.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yangzhenzhong.jpa_study.controller.common.ResultEntity;
import top.yangzhenzhong.jpa_study.exception.BizException;
import top.yangzhenzhong.jpa_study.exception.constants.ResultEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    private String systemNo="ZhongGege";

    private String getReturnCode(String code){
        return systemNo + code;
    }
    @ExceptionHandler
    public ResultEntity<?> handler(HttpServletRequest req, HttpServletResponse res, Exception e ) {
        logger.info("统一异常处理，Restful Http请求发生异常...");

        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        ResultEntity<?> resultEntity = new ResultEntity<>();

        if (e instanceof BizException) {
            logger.error("统一异常处理，异常代码00：" + e.getMessage());
            resultEntity.setCode(getReturnCode(((BizException) e).getCode()));
            resultEntity.setMsg(((BizException) e).getMsg());
            return resultEntity;
        }
        else {
            logger.error("统一异常处理，异常代码99：" + e.getMessage(), e);
            resultEntity.setCode(getReturnCode(ResultEnum.EXCEPTION.code));
            resultEntity.setMsg(ResultEnum.EXCEPTION.msg);
            return resultEntity;
        }
    }
}
