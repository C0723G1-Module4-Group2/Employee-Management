    package com.example.employee_manager.model;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDate;

    @Entity
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "teaching_schedule", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"time_sheet_id", "class_id", "start_date", "end_date"}),
            @UniqueConstraint(columnNames = {"time_sheet_id", "teacher_id", "start_date", "end_date"})
    })
    public class TeachingSchedule {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int teachingScheduleId;
        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "time_sheet_id",nullable = false)
        private TimeSheets timeSheets;
        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "class_id",nullable = false)
        private Classes classes;
        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "teacher_id",nullable = false)
        private Teacher teacher;
        @Column( name = "start_date",nullable = false)
        private LocalDate startDate;
        @Column(name="end_date",nullable = false)
        private LocalDate endDate;
        private boolean status;
    }
