package com.lcaohoanq.advanced.orm.associations.src.main.java.one_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spotNumber;

    @OneToOne(mappedBy = "parkingSpot")
    private EmployeeV2 employee;

    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
    }
}
