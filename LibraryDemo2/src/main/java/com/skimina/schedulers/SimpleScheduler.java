package com.skimina.schedulers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.skimina.entity.User;
import com.skimina.service.BookService;
import com.skimina.service.EmailService;
import com.skimina.service.UserService;

@Service
public class SimpleScheduler {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BookService bookService;

	@Scheduled(fixedDelay = 50000)
	public void demoServiceMethod() {
		List<User> users;
		try {
			users = userService.findAll();
			if (users != null) {
				for (User us : users) {
					String email = us.getEmail();
					emailService.sendEmail("test@gmail.com", email, "Books",
							"Hello. Please give back all your's rented books");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
