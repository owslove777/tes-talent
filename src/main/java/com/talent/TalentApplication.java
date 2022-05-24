package com.talent;

import com.talent.infrastructure.adapter.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;
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

	public static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(TalentApplication.class, args);
//
//		TalentRepository talentRepo = applicationContext.getBean(TalentRepository.class);
//		UserRepository userRepo = applicationContext.getBean(UserRepository.class);
//
//		TalentCategory talent = new TalentCategory();
//		talent.setCategoryName("피아노");
//		// talent.setLevel(Level.H);
//
//		talentRepo.save(talent);
//
//		System.out.println("########## talent 1");
//		System.out.println("talent : talentId=" + talent.getTalentId() + ", talentName=" + talent.getCategoryName());
//
//		// talent.getLevel().label());
//
//		User buyer = new User();
//		buyer.setName("아이유");
//		buyer.setAddress("용인시보정동");
//		// talent.setLevel(Level.H);
//
//		userRepo.save(buyer);
//
//		System.out.println("########## talent 1");
//		System.out.println("buyer : id=" + buyer.getUserId() + ", buyerName=" + buyer.getName() + ", buyerAddress="
//				+ buyer.getAddress());
//
//
//
//		TalentCategory talent2 = new TalentCategory();
//		talent2.setCategoryName("바이올린");
//		talentRepo.save(talent2);
//		System.out.println("############# talent 2");
//		System.out.println("talent : talentId=" + talent2.getTalentId() + ", talentName=" + talent2.getCategoryName());
//
//		User buyer2 = new User();
//		buyer2.setName("강호동");
//		buyer2.setAddress("서울시 마포구");
//		userRepo.save(buyer2);
//		System.out.println("########## user 2");
//		System.out.println("buyer : id=" + buyer2.getUserId() + ", buyerName=" + buyer2.getName() + ", buyerAddress="
//				+ buyer2.getAddress());
	}
}
