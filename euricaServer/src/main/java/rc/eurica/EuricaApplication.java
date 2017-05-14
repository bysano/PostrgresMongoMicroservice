package rc.eurica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by alka0317 on 5/3/2017.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaServer
public class EuricaApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EuricaApplication.class, args);
    }

}
