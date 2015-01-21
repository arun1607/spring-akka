package com.app.learning.repository;

import com.app.learning.model.Messege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amits on 21/01/15.
 */
public interface MessageRepository extends JpaRepository<Messege, Long> {

}