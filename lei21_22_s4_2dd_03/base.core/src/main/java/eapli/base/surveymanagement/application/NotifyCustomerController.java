package eapli.base.surveymanagement.application;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.surveymanagement.eventhandlers.NewSurveyEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 * Author: 1201180 - Guilherme Sencadas
 */

public class NotifyCustomerController {

    public void notifyCustomer(NewSurveyEvent event) {
        File file = new File("email.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
              sb.append(line).append("\n");
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Cannot read file!");
        }

        try(FileWriter fileWriter = new FileWriter(file)){
             List<Customer> customers = event.survey().audience();
             for (Customer customer : customers){
                 sb.append("Sent to: ").append(customer.email()).append("\n")
                         .append("Content: New Survey available to your account! Survey Code - ").append(event.survey().code().code()).append("\n\n");

             }
             fileWriter.write(sb.toString());
        }catch (Exception e){
            throw new RuntimeException("ERROR: Cannot write to file!");
        }
    }


}
