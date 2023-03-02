package com.finalproject.urproject.service;

import com.finalproject.urproject.entity.Leave;
import com.finalproject.urproject.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveService {
    @Autowired
    private LeaveRepository repository;
    public List<Leave> findAllLeave(){
        return repository.findAll();
    }
    public void saveLeave(Leave leave){
        repository.save(leave);
    }
    public Leave getLeaveById(Long id){
        return repository.findById(id).get();
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

}
