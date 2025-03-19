package com.asibeni.EduPraktika;

import com.asibeni.EduPraktika.model.Address;
import com.asibeni.EduPraktika.model.Course;
import com.asibeni.EduPraktika.model.Information;
import com.asibeni.EduPraktika.model.User;
import com.asibeni.EduPraktika.repositories.CourseRepository;
import com.asibeni.EduPraktika.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("com.asibeni.EduPraktika.repositories")
public class EduPraktikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduPraktikaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepo, CourseRepository courseRepo) {
		return args -> {
			User user1 = new User("Mugisha", "Mike", "at@gmail.com", "1234", "0788567889");
			userRepo.save(user1);
			User user4 = new User("me", "be", "aat@gmail.com", "1234", "0784597889");
			User user5 = new User("you", "ni", "art@gmail.com", "1234", "0734567889");
			User user6 = new User("us", "te", "abt@gmail.com", "1234", "0784567189");
            List<User> users = new ArrayList<User>();
			users.add(user1);
			users.add(user4);
			users.add(user5);
			users.add(user6);
			userRepo.saveAll(users);
			List<User>  allUsers = userRepo.findAll();
			for(User user : allUsers) {
				System.out.println(user.getEmail() + " " + user.getFirstName() + " " + user.getLastName()) ;
			}
			User user2 = userRepo.findByEmail("me@gmail.com");
			Address address = new Address("Rwamagana","muyumbu","101P","rwamagana");
			User user3 = new User("us", "te", "abt@gmail.com", "1234", "0784567189", address);
			userRepo.save(user3);
			System.out.println(user3.getAddress().getDistrict());
			Information information = new Information("2023","Level 4");

			User user = new User("beniteuser", "benite", "user@gmail.com", "1234", "0784567189", address);
			userRepo.save(user);
			Course course = new Course("math",information,user);
			courseRepo.save(course);
			List<Course> courses = courseRepo.findAll();
			for(Course c : courses) {
				System.out.println(c.getName()+ " "+ c.getInformation().getPublicationYear()+ c.getCreator().getFirstName());
			}

		};
	}
}
