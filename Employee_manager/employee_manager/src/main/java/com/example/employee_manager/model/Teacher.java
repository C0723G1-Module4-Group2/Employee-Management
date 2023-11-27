package com.example.employee_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "contract_id"})
})
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    @Column(nullable = false, unique = true)
    private String teacherCode;
    @Column(nullable = false)
    private String teacherName;
    @Column(nullable = false)
    private LocalDateTime dateOfBirth;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private boolean gender;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String identificationCard;
    @Column(nullable = false)
    private String basicSalary;
    @Column(nullable = false)
    private String warningCoefficient;
    private boolean status;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;
    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
    @OneToMany(mappedBy = "teacher")
    private Set<TeachingSchedule> teachingSchedules;
}
