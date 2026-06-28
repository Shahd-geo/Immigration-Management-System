package com.shahd.immigration_system.Dto;

import com.shahd.immigration_system.Entity.ImmigrationCenter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CenterDTO {

    private Long id;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    public static CenterDTO convertToDTO(ImmigrationCenter entity) {

        CenterDTO dto = new CenterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocationCountry(entity.getLocationCountry());
        dto.setType(entity.getType());
        dto.setDailyCapacity(entity.getDailyCapacity());
        return dto;
    }

    public static List<CenterDTO> convertToDTO(List<ImmigrationCenter> entities) {
        List<CenterDTO> dtos = new ArrayList<>();
        for (ImmigrationCenter entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}