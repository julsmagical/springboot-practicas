package com.springboot.jpa.hibernate.springboot_jpa_relationship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.hibernate.springboot_jpa_relationship.services.ManyToOneService;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner{

	private final ManyToOneService manyToOne;  

    SpringbootJpaRelationshipApplication(ManyToOneService manyToOne) {
        this.manyToOne = manyToOne;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne.findById();
	}

}
