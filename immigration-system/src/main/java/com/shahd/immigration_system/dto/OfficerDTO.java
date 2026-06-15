package com.shahd.immigration_system.dto;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OfficerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String badgeNumber;
    private String officerRank;

    public static OfficerDTO convertToDTO(ImmigrationOfficer entity) {

        OfficerDTO dto = new OfficerDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBadgeNumber(entity.getBadgeNumber());
        dto.setOfficerRank(entity.getOfficerRank());

        return dto;
    }

    public static List<OfficerDTO> convertToDTO(
            List<ImmigrationOfficer> entities) {

        List<OfficerDTO> dtos = new ArrayList<>();

        for (ImmigrationOfficer entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}