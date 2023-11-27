package com.example.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String nameTimeSheet;
    @OneToMany(mappedBy = "timeSheets")
    private Set<TeachingSchedule> teachingSchedules;
}
