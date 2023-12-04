package com.example.employee_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeSheets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeSheetId;
    @Column(unique = true, nullable = false)
    private String timeSheetName;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @JsonBackReference
    @OneToMany(mappedBy = "timeSheets")
    private Set<TeachingSchedule> teachingSchedules;
}
