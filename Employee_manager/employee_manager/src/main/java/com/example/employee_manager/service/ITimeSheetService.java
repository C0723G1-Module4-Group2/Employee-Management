package com.example.employee_manager.service;

import com.example.employee_manager.model.TimeSheets;

import java.util.List;

public interface ITimeSheetService {
    TimeSheets getTimeSheet(int id);
    List<TimeSheets> getAllTimeSheet();

}
