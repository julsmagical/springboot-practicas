package com.springboot.jpa.hibernate.springboot_jpa_relationship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.hibernate.springboot_jpa_relationship.services.ManyToOneService;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.services.OneToManyService;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner{

	private final ManyToOneService manyToOne;
	private final OneToManyService oneToMany;  


    SpringbootJpaRelationshipApplication(ManyToOneService manyToOne, OneToManyService oneToMany) {
        this.manyToOne = manyToOne;
		this.oneToMany = oneToMany;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToMany.findById();
	}

}
