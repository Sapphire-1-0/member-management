package com.brihaspathee.sapphire.interceptors;

import com.brihaspathee.sapphire.dto.auth.UserContext;
import com.brihaspathee.sapphire.dto.auth.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, February 2025
 * Time: 6:10 AM
 * Project: sapphire
 * Package Name: com.brihaspathee.sapphire.interceptors
 * To change this template use File | Settings | File and Code Template
 */

/**
 * UserContextInterceptor is a HandlerInterceptor implementation that processes
 * HTTP requests before they reach a controller. It serves as a mechanism to
 * perform pre-processing logic, such as injecting user context or validating the
 * request, to ensure proper handling downstream in the application.
 * <p>
 * This interceptor can be used to attach additional information to the request
 * or validate requests based on specific criteria. It is executed for each request
 * and can determine whether the flow of execution should proceed or be halted.
 * <p>
 * Implements:
 * - preHandle: Invoked before the actual handling of the request by the controller.
 * <p>
 * Annotations:
 * - @Slf4j: Provides a logger for this class to enable logging events at various levels.
 * - @Component: Marks this class as a Spring-managed component, allowing it to be
 *               automatically detected and registered in the application context.
 */
@Slf4j
@Component
public class UserContextInterceptor implements HandlerInterceptor {

    /**
     * Represents the name of the HTTP header used to identify the user ID
     * in the application. The value is injected from the application
     * properties using the key "application.user-info.user-id".
     */
    @Value("${application.user-info.user-id}")
    private String userIdHeader;

    /**
     * Represents the header key used to retrieve the username information
     * from the application's configuration properties.
     *
     * The value of this variable is injected from the 'application.user-info.username'
     * property defined in the application's configuration files.
     */
    @Value("${application.user-info.username}")
    private String usernameHeader;

    /**
     * Represents the header configuration property used for employee ID in the application.
     * The value is injected from the application's configuration or properties file using
     * the key "application.user-info.service-id".
     */
    @Value("${application.user-info.service-id}")
    private String serviceIdHeader;

    /**
     * Represents the header key used to retrieve the account type information
     * from the incoming HTTP request in the `UserContextInterceptor` class.
     * This value is injected through the application properties using the
     * Spring @Value annotation, mapped to the property key
     * `application.user-info.account-type`.
     *
     * This account type is utilized within the interceptor to extract
     * and include the user's account type in the user context for request handling.
     */
    @Value("${application.user-info.account-type}")
    private String accountTypeHeader;

    /**
     * Intercepts an HTTP request before it is handled by a controller to perform preprocessing logic.
     * The method extracts user-related data from the request headers and sets the user context,
     * enabling access to this data throughout the lifecycle of the request.
     *
     * @param request  the HttpServletRequest object containing the client request details
     * @param response the HttpServletResponse object containing the response details from the server
     * @param handler  the handler (or HandlerMethod) chosen to handle the request
     * @return true to continue the request processing; false to stop further processing
     * @throws Exception if any error occurs during the preprocessing
     */
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        String userId = request.getHeader(userIdHeader);
        String username = request.getHeader(usernameHeader);
        String serviceId = request.getHeader(serviceIdHeader);
        String accountType = request.getHeader(accountTypeHeader);
        log.info("User Context Interceptor: User Id: {}, Username: {}, Service Id: {}, Account Type: {}",
                userId, username, serviceId, accountType);
        if(userId != null){
            UserContext.setUser(UserDto.builder()
                            .username(username)
                            .userId(Long.parseLong(userId))
                            .serviceId(serviceId)
                            .accountType(accountType)
                    .build());
        }
        return true;

    }
}
