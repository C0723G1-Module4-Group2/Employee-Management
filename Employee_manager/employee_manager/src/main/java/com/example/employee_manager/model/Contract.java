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
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    @Column(nullable = false,unique = true)
    private String contractCode;
    @Column(nullable = false)
    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name="salary_level_id", nullable = false)
    private SalaryLevel salaryLevel;
    private boolean status;
}
