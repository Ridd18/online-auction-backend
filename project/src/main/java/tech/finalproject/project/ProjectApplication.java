package tech.finalproject.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;


//@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectApplication.class, args);
	}



	@Bean
	public CorsFilter corsFilter()
	{
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept", "Authorization","Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method","Access_Control-Request-Headers", "token" , "amount"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept", "Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials" , "token" , "amount"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


//	@Bean
//	WebMvcConfigurer WebMvcConfigurer()
//	{
//		return new WebMvcConfigurerAdapter()
//		{
//			@Override
//			public void addResourceHandlers(ResourceHandlerRegistry registry)
//			{
//				registry.addResourceHandler("/auction/image/**")
//						.addResourceLocations("classpath:/D://photos/");
//			}
//		};
//	}

	@Configuration
	public class ResourceConfigs implements WebMvcConfigurer
	{
		private final String[] CLASSPATH_RESOURCE_LOCATIONS =
				{
						"classpath:/META-INF/resources/",
						"classpath:/resources/",
						"classpath:/static/",
						"classpath:/public/",
						"classpath:/custom/",
						"file:///D:/photos/",

				};

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry
					.addResourceHandler("/files/**")
					.addResourceLocations("file:///D:/photos/");
		}
	}







}
