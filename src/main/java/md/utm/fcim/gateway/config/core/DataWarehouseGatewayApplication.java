package md.utm.fcim.gateway.config.core;

import md.utm.fcim.gateway.error.MyErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "md.utm.fcim.gateway")
@EnableHystrix
@EnableFeignClients(basePackages = "md.utm.fcim.gateway.client")
@EnableHystrixDashboard
public class DataWarehouseGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataWarehouseGatewayApplication.class, args);
    }

    @Bean
    public MyErrorDecoder myErrorDecoder() {
        return new MyErrorDecoder();
    }
}

@Component
class DiscoveryClientExample implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) {
        discoveryClient.getInstances("data-warehouse").forEach((serviceInstance -> {
            System.out.println("!!!!" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "--" + serviceInstance.getServiceId());
        }));
    }
}
