package com.fundamentosplatzi.springboot.fundamentos;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.apache.commons.logging.LogFactory;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private UserRepository userRepository;
	private final Log logger = LogFactory.getLog(this.getClass());
	private UserService userService;
	public FundamentosApplication(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService=userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private void saveUserInDataBase(){
		User user1= new User("Jhonn","Jhon@domain.com", LocalDate.of(2021,03,19));
		User user2= new User("Jhonn2","Jhon2@domain.com", LocalDate.of(2021,04,19));
		User user3= new User("Jhonn3","Jhon3@domain.com", LocalDate.of(2021,05,19));
		User user4= new User("Jhonn4","Jhon4@domain.com", LocalDate.of(2021,06,19));
		List<User> l= Arrays.asList(user1,user2,user3,user4);
		l.stream().forEach(userRepository::save);


	}

	private void getInformationJpqlFromUser(){
		System.out.println(userRepository.findByUserEmail("Jhon@domain.com").orElseThrow(()->new RuntimeException("No se encontro el usuario")));
		userRepository.findAndSort("Jhon", Sort.by("id").descending())
		.stream()
		.forEach(user -> logger.info("usuario con metodo sort"+user) );
		;
	userRepository.findByName("Jhonn")
			.stream()
			.forEach(user -> logger.info("usuario con query methods !!!!!"+user) );



	logger.info(userRepository.findByEmailAndName("Jhon2@domain.com","Jhonn2")
			.orElseThrow(()-> new RuntimeException("Usuario no encontrado")));


	userRepository.findByNameLike("%J%")
			.stream()
			.forEach(user -> logger.info(user));

	userRepository.findByNameOrEmail(null,"Jhon2@domain.com")
			.stream()
			.forEach(user -> logger.info(user));

	userRepository.findByBirthDateBetween(LocalDate.of(2021,4,1),LocalDate.of(2021,6,1))
			.stream()
			.forEach(user -> logger.info("usuario co intervalo de fechas"+user));



	}


	@Override
	public void run(String... args) throws Exception {
		saveUserInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransaccional();

	}



	private void saveWithErrorTransaccional(){
		User test1= new User("test","J@domain.com", LocalDate.of(2021,03,19));
		User test2= new User("test2","J2@domain.com", LocalDate.of(2021,04,19));
		User test3= new User("test3","J3@domain.com", LocalDate.of(2021,07,19));
		User test4= new User("test4","J4@domain.com", LocalDate.of(2021,06,19));
		List<User> users = Arrays.asList(test1,test2,test3,test4);
		userService.saveTransaccional(users);
		userService.getAllUser().stream().forEach(user ->
				logger.info("todos "+user));
	}


}
