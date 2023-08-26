package com.mekcoop.realestate;

import com.mekcoop.realestate.entity.enums.RoleType;
import com.mekcoop.realestate.payload.request.UserRequest;
import com.mekcoop.realestate.service.UserRoleService;
import com.mekcoop.realestate.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealestateApplication implements CommandLineRunner{

	private final UserRoleService userRoleService;
	private final UserService userService;

	public RealestateApplication(UserRoleService userRoleService, UserService userService) {
		this.userRoleService = userRoleService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RealestateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRoleService.getAllUserRole().isEmpty()){
			userRoleService.save(RoleType.ADMIN);
			userRoleService.save(RoleType.USER);
			userRoleService.save(RoleType.REAL_ESTATE);
		}
		if (userService.countAllUser()==0){
			UserRequest userRequest = new UserRequest();
			userRequest.setEmail("m.eminkecik@gmail.com");
			userRequest.setSsn("12345678910");
			userRequest.setFirstName("Muhammed");
			userRequest.setLastName("KECIK");
			userRequest.setPhoneNumber("531-906-2700");
			userRequest.setPassword("12345678");
			userService.saveUser(userRequest);
		}
	}


}
