package com.shahd.immigration_system.Service;

import com.shahd.immigration_system.Entity.ImmigrationCenter;
import com.shahd.immigration_system.Exception.ErrorMessages;
import com.shahd.immigration_system.Exception.ImmigrationException;
import com.shahd.immigration_system.Repository.CenterRepository;
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