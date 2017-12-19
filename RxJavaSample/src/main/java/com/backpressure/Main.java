package com.backpressure;

import static com.backpressure.Config.LOGGER;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;

/**
 * Created by fmap on 08.11.16.
 * http://127.0.0.1:8080/static?size=1000000
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {

        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try
        {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer(/*Config.BACKPRESSURE_ENABLED*/true));

            if (Config.BACKPRESSURE_ENABLED)
            {
                b.childOption(ChannelOption.WRITE_BUFFER_WATER_MARK, Config.WRITE_WATER_MARK);
            }

            int port = Config.PORT;
            Channel ch = b.bind(port).sync().channel();

            printEnv();

            LOGGER.info("Open your web browser and navigate to " + "http://127.0.0.1:{}", port);

            ch.closeFuture().sync();
        }
        finally
        {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            LOGGER.info("Server shutdown successfully");
        }
    }

    private static void printEnv()
    {
        LOGGER.info("Configuration:");
        LOGGER.info(Config.asString());
        LOGGER.info("leak detection level: " + ResourceLeakDetector.getLevel());
    }

}
