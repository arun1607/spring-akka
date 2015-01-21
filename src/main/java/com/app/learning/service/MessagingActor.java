package com.app.learning.service;

import akka.actor.UntypedActor;
import com.app.learning.model.Messege;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * An actor that can count using an injected CountingService.
 *
 * @note The scope here is prototype since we want to create a new actor
 * instance for use of this bean.
 */
@Named("MessagingActor")
@Scope("prototype")
class MessagingActor extends UntypedActor {

  public static class Count {}
  public static class Get {}

  // the service that will be automatically injected
  final MessageService messageService;

  @Inject
  public MessagingActor(@Named("messageService") MessageService messageService) {
    this.messageService = messageService;
  }

  private int count = 0;

  @Override
  public void onReceive(Object message) throws Exception {
    if (message instanceof Messege) {
      messageService.save((Messege) message);
    } else if (message instanceof Get) {
      getSender().tell(count, getSelf());
    } else {
      unhandled(message);
    }
  }
}
