package com.app.learning.service;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import com.app.learning.model.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.CountDownLatch;

/**
 * An actor that can count using an injected CountingService.
 *
 * @note The scope here is prototype since we want to create a new actor
 * instance for use of this bean.
 */
@Named("MessagingActor")
@Scope("prototype")
class MessagingActor extends UntypedActor {

    private final CountDownLatch latch;

    // the service that will be automatically injected
    @Inject
    @Qualifier("messageService")
    private MessageService messageService;

    public MessagingActor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Messege) {
            messageService.save((Messege) message);
            latch.countDown();
        }  else {
            unhandled(message);
        }
    }

    public static Props props(final CountDownLatch countDownLatch) {
        return Props.create(new Creator<MessagingActor>() {
            private static final long serialVersionUID = 1L;

            @Override
            public MessagingActor create() throws Exception {
                return new MessagingActor(countDownLatch);
            }
        });
    }
}
