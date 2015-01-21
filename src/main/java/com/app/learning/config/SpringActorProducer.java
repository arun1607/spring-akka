package com.app.learning.config;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * An actor producer that lets Spring create the Actor instances.
 */
public class SpringActorProducer implements IndirectActorProducer {
  final ApplicationContext applicationContext;
  final String actorBeanName;
  final CountDownLatch latch;

  public SpringActorProducer(ApplicationContext applicationContext,
                             String actorBeanName,CountDownLatch countDownLatch) {
    this.applicationContext = applicationContext;
    this.actorBeanName = actorBeanName;
    this.latch = countDownLatch;
  }

  @Override
  public Actor produce() {
    return (Actor) applicationContext.getBean(actorBeanName,latch);
  }

  @Override
  public Class<? extends Actor> actorClass() {
    return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
  }
}
