package io.daocloud.zuul2.demo.filters.inbound;

import com.netflix.zuul.filters.http.HttpInboundSyncFilter;
import com.netflix.zuul.message.http.HttpRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugFilter extends HttpInboundSyncFilter {

    private static final Logger log = LoggerFactory.getLogger(DebugFilter.class);


    @Override
    public HttpRequestMessage apply(HttpRequestMessage request) {
        request.getContext().setDebugRequest(true);
        request.getContext().setDebugRouting(true);

        log.info("in debug filter....");

        return request;
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter(HttpRequestMessage msg) {
        return true;
    }
}
