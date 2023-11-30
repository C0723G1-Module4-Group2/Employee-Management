    package com.example.employee_manager.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Entity
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "teaching_schedule", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"time_sheet_id","class_id"}),
            @UniqueConstraint(columnNames = {"time_sheet_id","teacher_id"}),
    })
    public class TeachingSchedule {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int teachingScheduleId;
        @ManyToOne
        @JoinColumn(name = "time_sheet_id",nullable = false)
        private TimeSheets timeSheets;
        @ManyToOne
        @JoinColumn(name = "class_id",nullable = false)
        private Classes classes;
        @ManyToOne
        @JoinColumn(name = "teacher_id",nullable = false)
        private Teacher teacher;
        private boolean status;
    }
