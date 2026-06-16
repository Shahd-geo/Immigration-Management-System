package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.ImmigrationCenter;
import com.shahd.immigration_system.exception.ErrorMessages;
import com.shahd.immigration_system.exception.ImmigrationException;
import com.shahd.immigration_system.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;
    //create new ImmigrationCenter
    public ImmigrationCenter saveCenter(ImmigrationCenter center) {
        return centerRepository.save(center);
    }

    public ImmigrationCenter getCenter(Long id) {
        return centerRepository.findById(id)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.CENTER_NOT_FOUND));
    }
}