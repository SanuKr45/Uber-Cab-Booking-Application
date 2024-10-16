package com.coding.project.uber.uberApp;

import com.coding.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail("tanmaysrivastava001@gmail.com",
				"APPLICATION STATUS FOR RECRUITMENT OF SPECIALIST CADRE OFFICERS IN STATE BANK OF INDIA ",
				"Dear Tanmay Srivastava,\n" +
						"\n" +
						"I hope this message finds you well.\n" +
						"\n" +
						"Thank you for applying for the position of Specialist Cadre Officer at the State Bank of India. After carefully reviewing your application, we regret to inform you that we are unable to proceed further with your candidacy due to incomplete or improper document submission as required in the recruitment process.\n"+
						"\n" +
						"State Bank of India"


		);
	}

	@Test
	void sendEmailToEveryone(){
		String [] emails = {
				"pevic39322@paxnw.com",
				"sanu967kumar@gmail.com"
//				"tanmaysrivastava001@gmail.com"
		};
		emailSenderService.sendEmail(emails, "Test email", "I learned to send emails, ");
	}

}
