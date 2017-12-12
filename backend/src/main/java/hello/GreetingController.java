package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "") String name) {
		List<Greeting> greetings = greetingRepository.findByName(name);
		if (greetings == null || greetings.isEmpty()) {
			return new Greeting(-1, "Anonymous", "Hello friend");
		}
		return greetings.get(0);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	public GreetingRepository getGreetingRepository() {
		return greetingRepository;
	}

	public void setGreetingRepository(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}
}
