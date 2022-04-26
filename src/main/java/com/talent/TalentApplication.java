package com.talent;

import com.talent.domain.*;
import com.talent.kafka.KafkaProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
// import org.springframework.hateoas.Link;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @RestController
@EnableAspectJAutoProxy
@EnableBinding(KafkaProcessor.class)
public class TalentApplication {

	static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(TalentApplication.class, args);

		TalentRepository talentRepo = applicationContext.getBean(TalentRepository.class);
		UserRepository userRepo = applicationContext.getBean(UserRepository.class);

		Talent talent = new Talent();
		talent.setTalentName("피아노");
		// talent.setLevel(Level.H);

		talentRepo.save(talent);

		System.out.println("talent : talentId=" + talent.getTalentId() + ", talentName=" + talent.getTalentName());

		// talent.getLevel().label());

		User buyer = new User();
		buyer.setName("아이유");
		buyer.setAddress("용인시보정동");
		// talent.setLevel(Level.H);

		userRepo.save(buyer);

		System.out.println("buyer : id=" + buyer.getUserId() + ", buyerName=" + buyer.getName() + ", buyerAddress="
				+ buyer.getAddress());
	}

	@Autowired
	RequestRepository requestRepository;

}
