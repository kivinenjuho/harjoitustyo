package fi.haagahelia.harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.harjoitustyo.domain.TeamRepository;
import fi.haagahelia.harjoitustyo.domain.User;
import fi.haagahelia.harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TeamRepository repository, UserRepository userRepository) {
		
		return (args) -> {
			
			User user1 = new User("user", "$2a$12$unvr9uCJ9/1E.crRjEu5/.XV6fN4o1tfVGNVwvyLYXERJUemTa.Au", "USER");
			User user2 = new User("admin", "$2a$12$jSxrt8NBN.NdsnFxrl9DiexsBtmvb29bIMJXVDp/FdkIRM96Wc.2W", "ADMIN");
			
			userRepository.save(user1);
			userRepository.save(user2);
				
		};
	}
}
