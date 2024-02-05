package com.example.Elfonze_SkillSync.Model;

import com.example.Elfonze_SkillSync.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "recrutier")
@Builder
public class Recrutier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int recruiterId;

     String userName;

     String password;

     String firstName;

      String lastName;

     String phoneNo;

    @Column(unique = true)
     String emailId;

     String mobileNo;

     int age;

@Column(unique = true)
     String panNo;

    @Column(unique = true)
     String adharNo;

     String position;

     int  experienceInYears;

     String responsibilities;

    @Enumerated(EnumType.STRING)
     Gender gender;

     String companyName;

     String companyWeb;

     String city;

     String zipCode;

//     one recruiter can post many jobs
    @OneToMany(mappedBy = "recrutier", cascade = CascadeType.ALL)
    List<JobEntity> jobEntityList;
}
