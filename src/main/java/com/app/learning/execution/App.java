package com.app.learning.execution;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.routing.RoundRobinPool;
import com.app.learning.config.AppConfig;
import com.app.learning.config.SpringExtension;
import com.app.learning.model.Customer;
import com.app.learning.model.Messege;
import com.app.learning.model.Person;
import com.app.learning.service.CustomerService;
import com.app.learning.service.MessageService;
import com.app.learning.service.PersonService;
import com.google.common.base.Stopwatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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

       singleThreadInsertion(app);
        Stopwatch stopwatch;
        Messege messege;
        long milis;
        // get hold of the actor system
        ActorSystem system = ctx.getBean(ActorSystem.class);
        // use the Spring Extension to create props for a named actor bean

        final CountDownLatch latch = new CountDownLatch(5000);
        stopwatch = Stopwatch.createStarted();

        ActorRef messenger = system.actorOf(
                SpringExtension.SpringExtProvider.get(system).props("MessagingActor", latch).withRouter(new RoundRobinPool(10)), "messenger");
        for (int i = 1; i <= 5000; i++) {
            Inbox inbox = Inbox.create(system);
            messege = new Messege();
            messege.setMessageText("Akka actor message : " + i);
            inbox.send(messenger, messege);
        }
        latch.await();
        milis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("Time consumed in processing : " + milis);
        //system.shutdown();
        //  system.shutdown();
        //  system.awaitTermination();


    }

    private static void singleThreadInsertion(App app) {
        Messege messege;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 1; i <= 5000; i++) {
            messege = new Messege();
            messege.setMessageText("Sending message in single thread : " + i);
            app.saveMessages(messege);
        }

        stopwatch.stop();
        long milis = stopwatch.elapsed(TimeUnit.MILLISECONDS);

        System.out.println("Time consumed in processing : " + milis);
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
