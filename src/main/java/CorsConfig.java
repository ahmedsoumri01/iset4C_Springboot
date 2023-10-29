import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // This allows CORS for all paths
                .allowedOrigins("http://localhost:3000")  // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow specific HTTP methods
        		
    }
}
