package com.example.employee_manager.dto;

import jakarta.persistence.Column;

public interface TimeSheetDto {
     String getTimeSheetId();

     String getTimeSheetName();
     String getStartTime();
     String getEndTime();
}
