package com.izerui.redis.command;

import com.izerui.redis.jpa.entity.RedisServerConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;

/**
 * Created by serv on 2015/2/8.
 */
public class JedisExecutor {

    private Jedis jedis = null;

    public JedisExecutor(RedisServerConfig server) {
        jedis = new Jedis(server.getHost(), server.getPort(), Protocol.DEFAULT_TIMEOUT);
        if (server.getPassword() != null && server.getPassword().length() > 0) {
            jedis.auth(server.getPassword());
        }
        if(server.getDbIndex()!=-1){
            jedis.select(server.getDbIndex());
        }
    }

    public <T extends Command> T execute(T command) {
        command.command(jedis);
        return command;
    }

    public Jedis getJedis() {
        return jedis;
    }
}
