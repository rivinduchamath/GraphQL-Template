package com.cloudofgoods.graphql;

import com.cloudofgoods.graphql.entity.CommonUserEntity;
import com.cloudofgoods.graphql.entity.Customer;
import com.cloudofgoods.graphql.entity.Vendor;
import com.cloudofgoods.graphql.repository.CommonUserRepository;
import com.cloudofgoods.graphql.repository.CustomerRepository;
import com.cloudofgoods.graphql.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class AppInitializer  implements CommandLineRunner {

    private final CommonUserRepository commonUserRepository;
    private final VendorRepository vendorRepository;
    private final CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Clean up database tables
        System.out.println("Delete DB TABLE");
        commonUserRepository.deleteAllInBatch();
        vendorRepository.deleteAllInBatch();
        customerRepository.deleteAllInBatch();

        //=========================================

        // Create a User instance
        CommonUserEntity firstUserCommonUserEntity = new CommonUserEntity("Nimal", "07787999444");
        CommonUserEntity secondUserCommonUserEntity = new CommonUserEntity("Jagath", "0314474411");
        CommonUserEntity thirdUserCommonUserEntity = new CommonUserEntity("Amal", "33443545455");


        // Create a UserProfile instance
        Customer customer = new Customer("228333");
        Vendor vendor = new Vendor("Venda");
        Vendor vendor2 = new Vendor("Ravi");


        // Set child reference(userProfile) in parent entity(user)
        firstUserCommonUserEntity.setCustomerProfileData(customer);
        secondUserCommonUserEntity.setVendorProfileData(vendor);
        thirdUserCommonUserEntity.setVendorProfileData(vendor2);

        // Set parent reference(user) in child entity(userProfile)
        customer.setCommonUser(firstUserCommonUserEntity);
        vendor.setCommonUser(secondUserCommonUserEntity);
        vendor2.setCommonUser(thirdUserCommonUserEntity);

        // Save Parent Reference (which will save the child as well)
        commonUserRepository.save(firstUserCommonUserEntity);
        commonUserRepository.save(secondUserCommonUserEntity);
        commonUserRepository.save(thirdUserCommonUserEntity);
// Agent , Customer , Driver , Vendor

        List<CommonUserEntity> all = commonUserRepository.findAll();

        for (CommonUserEntity al : all) {
            System.out.println("---------------------------------------");
            System.out.println("All User Common Repository\n" + al.getUserName() + "\n"
                    + "\n "
                    + al.getUserMobileNumber() + "\n" + al.getId()
            +"\n"
            );

            System.out.println("---------------------------------------");
            //System.out.println(al.getUserProfile2());
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        //Optional<User> all6 = userRepository.findById(1L);



        //System.out.println(all6+" AAAAAAAAAAAAAAAALLLLLLLLLLLLLL ");
        //  System.out.println(" BBBBBBBBBBBBBBBBBBB " +all6.get().getUserProfile().getPhoneNumber());

//        List<UserProfile> up = userProfileRepository.findAll();
//        for (UserProfile al : up) {
//            System.out.println("USER Profile Email \n" + al.getUser().getEmail() + " \n" + al.getPhoneNumber() + " " + al.getId() + "\n" + al.getUser());
//        }
//
//        List<UserProfile2> up2 = userProfileRepository1.findAll();
//        for (UserProfile2 al : up2) {
//            System.out.println("USER Profile2 Email \n" + al.getUser().getEmail() + " \n" + al.getPhoneNumber() + " " + al.getId() + "\n" + al.getUser());
//        }


        //=========================================
    }

}
