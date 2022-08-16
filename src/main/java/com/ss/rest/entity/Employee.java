
  package com.ss.rest.entity;
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
  
  @Entity
  @Data 
  public class Employee {
  
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer eno; 
  private String ename; 
  private String loc;
  private Double sal;
  
  
  }
 