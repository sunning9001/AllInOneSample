
package com.sun.httpserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.config.ConfigUtil;
import com.sun.config.Constants;
import com.sun.quartz.QuartzTest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * An HTTP server that sends back the content of the received HTTP request in a
 * pretty plaintext form.
 */
public final class HttpServer {
	
    private static final Logger logger =LoggerFactory.getLogger(HttpServer.class);
	public static void main(String[] args) throws Exception {

		// Configure the server.
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.option(ChannelOption.SO_BACKLOG, 1024);
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpServerInitializer());

			int port = ConfigUtil.getIntConfigProperties(Constants.PORT);
			Channel ch = b.bind(port).sync().channel();

			logger.debug("HttpServer start success ,bind port:<{}>",port);
			
			//定时任务 票据同步 --
			QuartzTest quart = new QuartzTest();
			quart.excuteSync();
			
			ch.closeFuture().sync();
			
			
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
