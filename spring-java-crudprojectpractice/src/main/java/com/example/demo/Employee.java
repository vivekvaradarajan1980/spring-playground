package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employees")
public class Employee {


    @JsonProperty("id")
    private Long empID;

    @JsonProperty("name")
    private String empName;

    @JsonFormat(pattern= "yyyy-MM-dd")
    private Date startDate;

    public Employee() {
    }

    public Employee(Long empID, String empName, Date startDate) {
        this.empID = empID;
        this.empName = empName;
        this.startDate = startDate;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
