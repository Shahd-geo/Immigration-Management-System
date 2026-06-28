package com.shahd.immigration_system.Dto;
import com.shahd.immigration_system.Entity.VisaApplication;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class VisaApplicationDTO {
    private Long id;
    private String visaType;
    private String status;

    public static VisaApplicationDTO convertToDTO(VisaApplication entity) {
        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setId(entity.getId());
        dto.setVisaType(entity.getVisaType());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<VisaApplicationDTO> convertToDTO(List<VisaApplication> entities) {
        List<VisaApplicationDTO> dtos = new ArrayList<>();
        for (VisaApplication entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}