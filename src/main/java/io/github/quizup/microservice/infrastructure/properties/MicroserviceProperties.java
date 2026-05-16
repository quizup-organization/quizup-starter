package io.github.quizup.microservice.infrastructure.properties;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Configuration properties for QuizUp Microservices Starter.
 * <p>
 * Provides auto-configuration for CORS, Swagger/OpenAPI, Exception Handling, and Actuator.
 * <p>
 * Example configuration:
 * <pre>
 * microservice:
 *   cors:
 *     enabled: true
 *     allowed-origins: http://localhost:3000,http://localhost:4200
 *     allowed-methods: GET,POST,PUT,DELETE
 *     allowed-headers: "*"
 *     allow-credentials: true
 *     max-age: 3600
 *   swagger:
 *     enabled: true
 *     version: 1.0.0
 *     description: API Documentation
 *     contact:
 *       name: QuizUp Team
 *       email: contact@quizup.com
 *       url: https://quizup.com
 *     license:
 *       name: Apache 2.0
 *       url: https://www.apache.org/licenses/LICENSE-2.0.html
 *   exception-handler:
 *     enabled: true
 *     log-stack-trace: true
 *     include-binding-errors: true
 *   actuator:
 *     enabled: true
 * </pre>
 */
@Validated
@ConfigurationProperties(prefix = "microservice")
public class MicroserviceProperties {

    @Valid
    @NestedConfigurationProperty
    private CorsProperties cors = new CorsProperties();

    @Valid
    @NestedConfigurationProperty
    private SwaggerProperties swagger = new SwaggerProperties();

    @Valid
    @NestedConfigurationProperty
    private ExceptionHandlerProperties exceptionHandler = new ExceptionHandlerProperties();

    @Valid
    @NestedConfigurationProperty
    private ActuatorProperties actuator = new ActuatorProperties();

    @Valid
    @NestedConfigurationProperty
    private ResourceServerProperties resourceServer = new ResourceServerProperties();

    @Valid
    @NestedConfigurationProperty
    private WebSocketProperties websocket = new WebSocketProperties();

    public CorsProperties getCors() {
        return cors;
    }

    public void setCors(CorsProperties cors) {
        this.cors = cors;
    }

    public SwaggerProperties getSwagger() {
        return swagger;
    }

    public void setSwagger(SwaggerProperties swagger) {
        this.swagger = swagger;
    }

    public ExceptionHandlerProperties getExceptionHandler() {
        return exceptionHandler;
    }

    public void setExceptionHandler(ExceptionHandlerProperties exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public ActuatorProperties getActuator() {
        return actuator;
    }

    public void setActuator(ActuatorProperties actuator) {
        this.actuator = actuator;
    }

    public ResourceServerProperties getResourceServer() {
        return resourceServer;
    }

    public void setResourceServer(ResourceServerProperties resourceServer) {
        this.resourceServer = resourceServer;
    }

    public WebSocketProperties getWebsocket() {
        return websocket;
    }

    public void setWebsocket(WebSocketProperties websocket) {
        this.websocket = websocket;
    }

    /**
     * Configuration properties for CORS (Cross-Origin Resource Sharing)
     */
    public static class CorsProperties {

        /**
         * Enable or disable CORS configuration
         */
        private boolean enabled = true;

        /**
         * List of allowed origins. Use "*" for all origins or specific URLs.
         * When allowCredentials is true, cannot use "*" - must specify actual origins.
         */
        @NotEmpty(message = "At least one allowed origin must be specified")
        private List<String> allowedOrigins = List.of("*");

        /**
         * List of allowed HTTP methods
         */
        @NotEmpty(message = "At least one allowed method must be specified")
        private List<String> allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");

        /**
         * List of allowed headers
         */
        @NotEmpty(message = "At least one allowed header must be specified")
        private List<String> allowedHeaders = List.of("*");

        /**
         * List of exposed headers
         */
        private List<String> exposedHeaders = List.of();

        /**
         * Whether credentials (cookies, authorization headers) are allowed
         */
        private boolean allowCredentials = true;

        /**
         * How long (in seconds) the response from a pre-flight request can be cached
         */
        private Long maxAge = 3600L;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }

        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = allowedOrigins;
        }

        public List<String> getAllowedMethods() {
            return allowedMethods;
        }

        public void setAllowedMethods(List<String> allowedMethods) {
            this.allowedMethods = allowedMethods;
        }

        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }

        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }

        public List<String> getExposedHeaders() {
            return exposedHeaders;
        }

        public void setExposedHeaders(List<String> exposedHeaders) {
            this.exposedHeaders = exposedHeaders;
        }

        public boolean isAllowCredentials() {
            return allowCredentials;
        }

        public void setAllowCredentials(boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }

        public Long getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(Long maxAge) {
            this.maxAge = maxAge;
        }

    }

    /**
     * Configuration properties for Swagger/OpenAPI documentation
     */
    public static class SwaggerProperties {

        /**
         * Enable or disable Swagger/OpenAPI configuration
         */
        private boolean enabled = true;

        /**
         * API version
         */
        @NotEmpty(message = "API version must be specified")
        private String version = "1.0.0";

        /**
         * API description
         */
        @NotEmpty(message = "API description must be specified")
        private String description = "API Documentation";

        /**
         * Terms of service URL
         */
        private String termsOfService;

        private boolean useRootPath = true;

        private boolean showOauth2Endpoints = false;

        /**
         * Contact information
         */
        @Valid
        @NestedConfigurationProperty
        private ContactProperties contact = new ContactProperties();

        /**
         * License information
         */
        @Valid
        @NestedConfigurationProperty
        private LicenseProperties license = new LicenseProperties();

        /**
         * OAuth2 configuration for Swagger UI
         */
        @Valid
        @NestedConfigurationProperty
        private OAuth2Properties oauth2 = new OAuth2Properties();

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTermsOfService() {
            return termsOfService;
        }

        public void setTermsOfService(String termsOfService) {
            this.termsOfService = termsOfService;
        }

        public boolean isUseRootPath() {
            return useRootPath;
        }

        public void setUseRootPath(boolean useRootPath) {
            this.useRootPath = useRootPath;
        }

        public boolean isShowOauth2Endpoints() {
            return showOauth2Endpoints;
        }

        public void setShowOauth2Endpoints(boolean showOauth2Endpoints) {
            this.showOauth2Endpoints = showOauth2Endpoints;
        }

        public ContactProperties getContact() {
            return contact;
        }

        public void setContact(ContactProperties contact) {
            this.contact = contact;
        }

        public LicenseProperties getLicense() {
            return license;
        }

        public void setLicense(LicenseProperties license) {
            this.license = license;
        }

        public OAuth2Properties getOauth2() {
            return oauth2;
        }

        public void setOauth2(OAuth2Properties oauth2) {
            this.oauth2 = oauth2;
        }

        /**
         * OAuth2 configuration for Swagger UI authentication
         */
        public static class OAuth2Properties {

            /**
             * Enable OAuth2 security in Swagger UI
             */
            private boolean enabled = true;

            /**
             * Authorization Server URL (issuer)
             */
            private String authorizationServerUrl = "http://localhost:8085";

            /**
             * OAuth2 Client ID for Swagger UI
             */
            private String clientId = "swagger";

            /**
             * OAuth2 scopes to request
             */
            private List<String> scopes = List.of("openid", "profile");

            /**
             * Use PKCE (Proof Key for Code Exchange) - recommended for public clients
             */
            private boolean usePkce = true;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getAuthorizationServerUrl() {
                return authorizationServerUrl;
            }

            public void setAuthorizationServerUrl(String authorizationServerUrl) {
                this.authorizationServerUrl = authorizationServerUrl;
            }

            public String getClientId() {
                return clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public List<String> getScopes() {
                return scopes;
            }

            public void setScopes(List<String> scopes) {
                this.scopes = scopes;
            }

            public boolean isUsePkce() {
                return usePkce;
            }

            public void setUsePkce(boolean usePkce) {
                this.usePkce = usePkce;
            }

        }

        /**
         * Contact information for the API
         */
        public static class ContactProperties {

            /**
             * Contact name
             */
            private String name = "QuizUp Team";

            /**
             * Contact email
             */
            private String email = "contact@quizup.com";

            /**
             * Contact URL
             */
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }

        /**
         * License information for the API
         */
        public static class LicenseProperties {

            /**
             * License name
             */
            private String name = "Apache 2.0";

            /**
             * License URL
             */
            private String url = "https://www.apache.org/licenses/LICENSE-2.0.html";

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }
    }

    /**
     * Configuration properties for Exception Handler
     */
    public static class ExceptionHandlerProperties {

        /**
         * Enable or disable global exception handler
         */
        private boolean enabled = true;

        /**
         * Log full stack trace for errors
         */
        private boolean logStackTrace = true;

        /**
         * Include binding errors in validation exception responses
         */
        private boolean includeBindingErrors = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isLogStackTrace() {
            return logStackTrace;
        }

        public void setLogStackTrace(boolean logStackTrace) {
            this.logStackTrace = logStackTrace;
        }

        public boolean isIncludeBindingErrors() {
            return includeBindingErrors;
        }

        public void setIncludeBindingErrors(boolean includeBindingErrors) {
            this.includeBindingErrors = includeBindingErrors;
        }

    }

    /**
     * Configuration properties for Spring Boot Actuator
     */
    public static class ActuatorProperties {

        /**
         * Enable or disable Actuator auto-configuration
         */
        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

    }

    /**
     * Configuration properties for Resource Server (OAuth2 JWT validation)
     */
    public static class ResourceServerProperties {

        /**
         * Enable or disable Resource Server auto-configuration
         */
        private boolean enabled = true;

        /**
         * JWT configuration
         */
        @Valid
        @NestedConfigurationProperty
        private JwtProperties jwt = new JwtProperties();

        public static class JwtProperties {

            /**
             * JWT Issuer URI (for token validation)
             */
            private String issuerUri = "http://localhost:8085";

            /**
             * JWK Set URI (for fetching public keys)
             */
            private String jwkSetUri = "http://localhost:8085/oauth2/jwks";

            public String getIssuerUri() {
                return issuerUri;
            }

            public void setIssuerUri(String issuerUri) {
                this.issuerUri = issuerUri;
            }

            public String getJwkSetUri() {
                return jwkSetUri;
            }

            public void setJwkSetUri(String jwkSetUri) {
                this.jwkSetUri = jwkSetUri;
            }

        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public JwtProperties getJwt() {
            return jwt;
        }

        public void setJwt(JwtProperties jwt) {
            this.jwt = jwt;
        }
    }

    /**
     * Configuration properties for WebSocket STOMP.
     * <p>
     * Example:
     * <pre>
     * microservice:
     *   websocket:
     *     enabled: true
     *     endpoint: /ws
     *     application-destination-prefix: /app
     *     broker-destinations:
     *       - /topic
     *       - /queue
     *     allowed-origin-patterns:
     *       - "*"
     *     with-sock-js: true
     * </pre>
     */
    public static class WebSocketProperties {

        /**
         * Enable or disable WebSocket auto-configuration
         */
        private boolean enabled = true;

        /**
         * STOMP endpoint path (SockJS handshake)
         */
        @NotEmpty(message = "WebSocket endpoint must be specified")
        private String endpoint = "/ws";

        /**
         * Application destination prefix for @MessageMapping methods
         */
        @NotEmpty(message = "Application destination prefix must be specified")
        private String applicationDestinationPrefix = "/app";

        /**
         * Simple broker destination prefixes
         */
        @NotEmpty(message = "At least one broker destination must be specified")
        private List<String> brokerDestinations = List.of("/topic", "/queue");

        /**
         * Allowed origin patterns for the WebSocket endpoint
         */
        @NotEmpty(message = "At least one allowed origin pattern must be specified")
        private List<String> allowedOriginPatterns = List.of("*");

        /**
         * Whether to enable SockJS fallback
         */
        private boolean withSockJs = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getApplicationDestinationPrefix() {
            return applicationDestinationPrefix;
        }

        public void setApplicationDestinationPrefix(String applicationDestinationPrefix) {
            this.applicationDestinationPrefix = applicationDestinationPrefix;
        }

        public List<String> getBrokerDestinations() {
            return brokerDestinations;
        }

        public void setBrokerDestinations(List<String> brokerDestinations) {
            this.brokerDestinations = brokerDestinations;
        }

        public List<String> getAllowedOriginPatterns() {
            return allowedOriginPatterns;
        }

        public void setAllowedOriginPatterns(List<String> allowedOriginPatterns) {
            this.allowedOriginPatterns = allowedOriginPatterns;
        }

        public boolean isWithSockJs() {
            return withSockJs;
        }

        public void setWithSockJs(boolean withSockJs) {
            this.withSockJs = withSockJs;
        }

    }
}
