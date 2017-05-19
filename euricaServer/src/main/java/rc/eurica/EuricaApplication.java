package rc.eurica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaServer
public class EuricaApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EuricaApplication.class, args);
    }

}
