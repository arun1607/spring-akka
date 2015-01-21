package com.app.learning.service;

import com.app.learning.model.Messege;
import com.app.learning.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by amits on 21/01/15.
 */
@Named("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    
    @Override
    @Transactional
    public Messege save(Messege entity) {
        return messageRepository.save(entity);
    }

    @Override
    public List<Messege> findAll() {
        return null;
    }

    @Override
    public void delete(Messege entity) {

    }

    @Override
    public Messege findById(Long id) {
        return null;
    }

    @Override
    public void populate() {

    }

    @Override
    public void showDetails() {

    }
}
