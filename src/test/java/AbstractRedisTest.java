import com.izerui.redis.command.Command;
import com.izerui.redis.command.JedisExecutor;
import com.izerui.redis.jpa.entity.RedisServerConfig;
import org.junit.Before;

/**
 * Created by serv on 2015/2/8.
 */
public abstract class AbstractRedisTest {

    protected JedisExecutor executor;

    @Before
    public void before(){
        executor = new JedisExecutor(server());
    }

    public abstract RedisServerConfig server();

    public <T extends Command> T execute(T command){
        return executor.execute(command);
    }

}
