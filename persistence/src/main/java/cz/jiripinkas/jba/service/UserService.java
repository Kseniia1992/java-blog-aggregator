package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ksolodovnik
 */
@Transactional
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
