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


@SpringBootApplication
@EnableJpaRepositories("com.asibeni.EduPraktika.repositories")
public class EduPraktikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduPraktikaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepo, CourseRepository courseRepo) {
		return args -> {
			Address address = new Address("Rwamagana","muyumbu","rwanda","rwamagana");
			User user1 = new User("Mugisha", "Mike","mugishamike", "at@gmail.com", "0788567889", address,"ioguf yx");
			userRepo.save(user1);
			User user2 = new User("Mugisha", "Mike","mugimike", "meat@gmail.com", "0788467889", address,"ioguf yx");
            List<User> users = new ArrayList<User>();
			users.add(user1);
			users.add(user2);
			userRepo.saveAll(users);
			List<User>  allUsers = userRepo.findAll();
			for(User user : allUsers) {
				System.out.println(user.getEmail() + " " + user.getFirstName() + " " + user.getLastName()) ;
			}
			Information information = new Information("2023","Level 4");
			Course course = new Course("math",information,user2);
			courseRepo.save(course);
			List<Course> courses = courseRepo.findAll();
			for(Course c : courses) {
				System.out.println(c.getName()+ " "+ c.getInformation().getPublicationYear()+ c.getCreator().getFirstName());
			}

		};
	}
}
