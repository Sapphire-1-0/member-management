package com.brihaspathee.sapphire.feign.client;

import com.brihaspathee.sapphire.model.WelcomeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, December 2024
 * Time: 3:08 PM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.feign.client
 * To change this template use File | Settings | File and Code Template
 */
@FeignClient(
        name = "premium-billing",
        url = "${application.config.premium-billing-url}"
)
public interface PremiumBillingClient {

    @GetMapping("/welcome")
    WelcomeDto welcomeMessage();
}
