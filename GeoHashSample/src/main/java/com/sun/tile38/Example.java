package com.sun.tile38;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.output.StatusOutput;
import io.lettuce.core.protocol.CommandArgs;
import io.lettuce.core.protocol.CommandType;

/**
 * Example for using Tile38 in Java using lettuce version 5.0.1.Beta1
 */
public class Example {

    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://localhost:9851");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCommands<String, String> sync = connection.sync();

        StringCodec codec = StringCodec.UTF8;
        sync.dispatch(CommandType.SET,
                new StatusOutput<>(codec), new CommandArgs<>(codec)
                        .add("fleet")
                        .add("truck1")
                        .add("POINT")
                        .add(33L)
                        .add(-115L));

        String result = sync.dispatch(CommandType.GET,
                new StatusOutput<>(codec), new CommandArgs<>(codec)
                        .add("fleet")
                        .add("truck1"));

        System.out.println(result);
    }
}