package com.dulich.tourism.config;


import com.dulich.tourism.models.account.Role;
import com.dulich.tourism.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {

            if (roleRepository.findByName("Admin") == null) {
                Role adminRole = new Role();
                adminRole.setName("Admin");
                roleRepository.save(adminRole);
            }

            if (roleRepository.findByName("Hotel-Owner") == null) {
                Role hotelRole = new Role();
                hotelRole.setName("Hotel-Owner");
                roleRepository.save(hotelRole);
            }

            if (roleRepository.findByName("Tour-Owner") == null){
                Role tourRole = new Role();
                tourRole.setName("Tour-Owner");
                roleRepository.save(tourRole);
            }

            if (roleRepository.findByName("Customer") == null) {
                Role customerRole = new Role();
                customerRole.setName("Customer");
                roleRepository.save(customerRole);
            }
        };
    }
}

