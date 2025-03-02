package com.brihaspathee.sapphire.config;

import com.brihaspathee.sapphire.interceptors.UserContextInterceptor;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, February 2025
 * Time: 5:03 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * A final instance of the UserContextInterceptor that is used to intercept
     * HTTP requests and perform pre-processing logic, such as injecting or validating
     * user context.
     * <p>
     * This interceptor is designed to operate during the lifecycle of a request,
     * ensuring that user-related data, such as user ID or username, is extracted
     * and set in a thread-safe manner for downstream processing. It leverages the
     * UserContext class to associate user-specific information with the current thread.
     * <p>
     * The UserContextInterceptor is executed for each request within the web application
     * and is pivotal for maintaining contextual information about the user for the
     * duration of the request lifecycle.
     * <p>
     * Being a final field ensures its immutability, thereby providing a consistent
     * and reliable mechanism for pre-request processing in the web application.
     */

    private final UserContextInterceptor userContextInterceptor;

    /**
     * Registers the application's interceptors to support additional pre-processing
     * or post-processing of HTTP requests in the web application.
     * Specifically, it adds the {@code UserContextInterceptor} to the registry,
     * ensuring it is applied to incoming requests.
     *
     * @param registry the {@link InterceptorRegistry} used for registering interceptors
     *                 within the Spring Web MVC configuration
     */
    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor);
    }
}
