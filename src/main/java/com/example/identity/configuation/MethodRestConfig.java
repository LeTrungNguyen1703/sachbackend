//package com.example.identity.configuation;
//
//import com.example.identity.entity.TheLoai;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.metamodel.Type;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//
//@Configuration
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class MethodRestConfig implements RepositoryRestConfigurer {
//    String url = "http://localhost:3000";
//
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//
//        // CORS configuration
//        cors.addMapping("/**")
//                .allowedOrigins(url)
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*")
//                .exposedHeaders("Authorization", "Link")
//                .allowCredentials(true)
//                .maxAge(3600);
//
//    }
//}
