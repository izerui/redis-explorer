import com.izerui.redis.command.key.Encoding;
import com.izerui.redis.command.key.ListKeys;
import com.izerui.redis.command.key.Size;
import com.izerui.redis.command.key.TTLs;
import com.izerui.redis.command.server.DbAmount;
import com.izerui.redis.command.server.ServerProperties;
import com.izerui.redis.jpa.entity.RedisServerConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;

import java.util.List;

/**
 * Created by serv on 2015/2/8.
 */
public class JedisTest extends AbstractRedisTest{

    @Override
    public RedisServerConfig server() {
        RedisServerConfig server = new RedisServerConfig();
        server.setHost("192.168.1.236");
        server.setDbIndex(0);
        server.setPort(6379);
        return server;
    }

    @Test
    public void read(){
        System.out.println(execute(new DbAmount()).getDbAmount());
        System.out.println(execute(new ServerProperties()).getServerInfo().toString());
        System.out.println(execute(new Encoding("sdfsdf")).getEncoding());
        System.out.println(execute(new ListKeys()).getKeys().toString());
        System.out.println(execute(new Size("abc")).getSize());
        System.out.println(execute(new TTLs("abc")).getSecond());
    }

    @Test
    public void page(){
        Jedis jedis = executor.getJedis();
        ScanParams params = new ScanParams();
        params.match("CAS:*");
        List<String> result = jedis.scan("0",params).getResult();
        System.out.println(result);
    }


}
