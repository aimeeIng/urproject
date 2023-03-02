package com.finalproject.urproject.security;

import com.finalproject.urproject.entity.Employee;
import com.finalproject.urproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository repository;

/*
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        if (user == null) {
            throw new UsernameNotFoundException("User with username '" + username + "' does not exist.");
        }
        return user;
    }*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> userInfo = repository.findByEmail(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
