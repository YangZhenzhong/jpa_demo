package top.yangzhenzhong.jpa_study.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import top.yangzhenzhong.jpa_study.controller.common.BasicConstants;
import top.yangzhenzhong.jpa_study.controller.common.IdWorker;
import top.yangzhenzhong.jpa_study.controller.common.LocalData;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpTxidFilter implements Filter{

    private final static Logger logger = LoggerFactory.getLogger(HttpTxidFilter.class);

    private static IdWorker generateTxId = new IdWorker(0, 0);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init http txid filter ... ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String txId = httpServletRequest.getHeader(BasicConstants.TX_ID);
        if (txId == null || txId == "") {
            txId = String.valueOf(generateTxId.nextId());
            logger.info("生成的TXID为：{}",txId);
        }
        LocalData.TXID.set(txId);
        Map<String,String> txidMap = new HashMap<>();
        txidMap.put("txId",txId);
        MDC.setContextMap(txidMap);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    		
    }
}
