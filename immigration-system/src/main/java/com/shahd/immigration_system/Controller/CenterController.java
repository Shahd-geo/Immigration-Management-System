package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.dto.CenterDTO;
import com.shahd.immigration_system.entity.ImmigrationCenter;
import com.shahd.immigration_system.service.CenterService;
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

