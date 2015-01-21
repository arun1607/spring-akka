package com.app.learning.execution;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import com.app.learning.config.AppConfig;
import com.app.learning.config.SpringExtension;
import com.app.learning.model.Customer;
import com.app.learning.model.Messege;
import com.app.learning.model.Person;
import com.app.learning.service.CustomerService;
import com.app.learning.service.MessageService;
import com.app.learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private PersonService personService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageService messageService;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                AppConfig.class);
        App app = ctx.getBean("app", App.class);

        Messege messege;
//        long startTime = System.currentTimeMillis();
//        for (int i = 1; i <= 1000; i++) {
//            message = new Message();
//            message.setMessageText("Hello number : " + i);
//            app.saveMessages(message);
//        }
//
//        long duration = System.currentTimeMillis() - startTime;

//        System.out.println("Time consumed in processing : " + duration);
        // get hold of the actor system
        ActorSystem system = ctx.getBean(ActorSystem.class);
        // use the Spring Extension to create props for a named actor bean
        
        
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            ActorRef messenger = system.actorOf(
                    SpringExtension.SpringExtProvider.get(system).props("MessagingActor"), "messenger"+i);
            Inbox inbox = Inbox.create(system);
            messege = new Messege();
            messege.setMessageText("Hello number : " + i);
            inbox.send(messenger, messege);
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Time consumed in processing : " + duration);
        Thread.sleep(120000);
        system.shutdown();
      //  system.shutdown();
      //  system.awaitTermination();


    }

    public Messege saveMessages(Messege messege) {
        return messageService.save(messege);
    }

    public void showCustomerDetails() {
        customerService.showDetails();

    }

    public void populateCustomer() {
        customerService.populate();

    }

    public void showPersonDetails() {
        personService.showDetails();

    }

    public void populatePerson() {
        personService.populate();

    }

    public void deletePerson() {

        Person person = personService.findById(1L);
        personService.delete(person);
    }

    public void deleteCustomer() {
        Customer customer = customerService.findById(1L);
        customerService.delete(customer);
    }

}
