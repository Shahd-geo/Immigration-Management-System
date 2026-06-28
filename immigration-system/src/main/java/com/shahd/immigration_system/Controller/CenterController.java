package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.Dto.CenterDTO;
import com.shahd.immigration_system.Entity.ImmigrationCenter;
import com.shahd.immigration_system.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;
    @PostMapping
    public CenterDTO createCenter(@RequestBody ImmigrationCenter center) {

        return CenterDTO.convertToDTO(centerService.saveCenter(center)
        );
    }
    @GetMapping("/{id}")
    public CenterDTO getCenter(@PathVariable Long id) {

        return CenterDTO.convertToDTO(centerService.getCenter(id)
        );
    }
}

