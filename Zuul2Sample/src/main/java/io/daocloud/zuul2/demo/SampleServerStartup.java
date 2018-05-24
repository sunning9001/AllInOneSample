package io.daocloud.zuul2.demo;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.config.DynamicIntProperty;
import com.netflix.discovery.EurekaClient;
import com.netflix.netty.common.accesslog.AccessLogPublisher;
import com.netflix.netty.common.channel.config.ChannelConfig;
import com.netflix.netty.common.channel.config.CommonChannelConfigKeys;
import com.netflix.netty.common.metrics.EventLoopGroupMetrics;
import com.netflix.netty.common.proxyprotocol.StripUntrustedProxyHeadersHandler;
import com.netflix.netty.common.status.ServerStatusManager;
import com.netflix.spectator.api.Registry;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.FilterUsageNotifier;
import com.netflix.zuul.RequestCompleteHandler;
import com.netflix.zuul.context.SessionContextDecorator;
import com.netflix.zuul.netty.server.BaseServerStartup;
import com.netflix.zuul.netty.server.DirectMemoryMonitor;
import com.netflix.zuul.netty.server.ZuulServerChannelInitializer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class SampleServerStartup extends BaseServerStartup {

    @Inject
    public SampleServerStartup(ServerStatusManager serverStatusManager, FilterLoader filterLoader, SessionContextDecorator sessionCtxDecorator, FilterUsageNotifier usageNotifier, RequestCompleteHandler reqCompleteHandler, Registry registry, DirectMemoryMonitor directMemoryMonitor, EventLoopGroupMetrics eventLoopGroupMetrics, EurekaClient discoveryClient, ApplicationInfoManager applicationInfoManager, AccessLogPublisher accessLogPublisher) {
        super(serverStatusManager, filterLoader, sessionCtxDecorator, usageNotifier, reqCompleteHandler, registry, directMemoryMonitor, eventLoopGroupMetrics, discoveryClient, applicationInfoManager, accessLogPublisher);
    }

    @Override
    protected Map<Integer, ChannelInitializer> choosePortsAndChannels(ChannelGroup clientChannels, ChannelConfig channelDependencies) {
        int port = new DynamicIntProperty("zuul.server.port.main", 7001).get();

        ChannelConfig channelConfig = BaseServerStartup.defaultChannelConfig();

        Map<Integer, ChannelInitializer> portsToChannels = new HashMap<>();

        channelConfig.set(CommonChannelConfigKeys.allowProxyHeadersWhen, StripUntrustedProxyHeadersHandler.AllowWhen.ALWAYS);
        channelConfig.set(CommonChannelConfigKeys.preferProxyProtocolForClientIp, false);
        channelConfig.set(CommonChannelConfigKeys.isSSlFromIntermediary, false);
        channelConfig.set(CommonChannelConfigKeys.withProxyProtocol, false);

        portsToChannels.put(port, new ZuulServerChannelInitializer(port, channelConfig, channelDependencies, clientChannels));
        logPortConfigured(port, null);

        return portsToChannels;
    }
}
