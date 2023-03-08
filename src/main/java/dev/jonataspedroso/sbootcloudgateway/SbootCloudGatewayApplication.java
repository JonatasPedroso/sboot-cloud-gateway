package dev.jonataspedroso.sbootcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SbootCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootCloudGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/cliente/**").uri("lb://sboot-cliente-service"))
				.route(r -> r.path("/cartoes/**").uri("lb://sboot-cartoes-service"))
				.build();
	}

}
