package com.example.ticketbooking.booking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BusTicketBooking API ")
                        .description("BusTicketBookingAPP API for user")
                        .version("1.0")
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("BusTicketBookingAPP Rest API License")
                                .url("https://www.BusTicketBooking.com/license"))
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Support")
                                .email("support@BusTicketBooking.com")
                                .url("https://www.BusTicketBooking.com/support"))
                );
    }
}
