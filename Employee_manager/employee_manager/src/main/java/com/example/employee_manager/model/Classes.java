package com.example.employee_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;
    @Column(nullable = false)
    private String className;
    private boolean status;
    @JsonBackReference
    @OneToMany(mappedBy = "classes")
    private Set<TeachingSchedule> teachingSchedules;
}
