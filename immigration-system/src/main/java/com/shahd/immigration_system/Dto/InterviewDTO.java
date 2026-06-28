package com.shahd.immigration_system.Dto;

import com.shahd.immigration_system.Entity.Interview;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class InterviewDTO {
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;

    public static InterviewDTO convertToDTO(Interview entity) {
        InterviewDTO dto = new InterviewDTO();
        dto.setId(entity.getId());
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setStatus(entity.getStatus());
        dto.setPurpose(entity.getPurpose());

        return dto;
    }

    public static List<InterviewDTO> convertToDTO(List<Interview> entities) {
        List<InterviewDTO> dtos = new ArrayList<>();
        for (Interview entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}