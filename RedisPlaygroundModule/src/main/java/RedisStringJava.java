import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisStringJava {

    /**
     * For the example tp work, you must first install Redis like here:
     * http://www.tutorialspoint.com/redis/redis_environment.htm
     *
     * The example is from here:
     * http://www.tutorialspoint.com/redis/redis_java.htm
     */
    public static void main(String[] args) {

        System.out.println("Starting Redis...");

        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");

        if(jedis.isConnected())
            System.out.println("Connection to server successfully");
        else
            System.out.println("Connection to server not successful!");

        //check whether server is running or not
        System.out.println("Server is running: "+ jedis.ping());

        /**
         * Set data in Redis
         */
        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));

        /**
         * Set data list in Redis
         */
        //store data in redis list
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }

        /**
         *
         */
        Set<String> keys = jedis.keys("*");
        for(String key: keys) {
            System.out.println("List of stored keys:: " + key);
        }
    }
}
