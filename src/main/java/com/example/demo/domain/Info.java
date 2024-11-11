package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {

  private int EMP_CD;
  private String EMP_NM;
  private String GENDER_CD;
  private String JOIN_DATE;
  private String POSITION_CD;
  private String DUTY_CD;
  private String ROLE_CD;
  private String ASSIGNED_TAS;
  private String EMAIL;
  private String ZIP_CD;
  private String ADDRESS1;
  private String ADDRESS2;
  private String CREATED_DATE;
  private String UPDATED_DATE;
  private String rowStatus;



    @Builder
    public Info(int EMP_CD, String EMP_NM, String GENDER_CD, String JOIN_DATE, String POSITION_CD, String DUTY_CD, String ROLE_CD, String ASSIGNED_TAS, String EMAIL, String ZIP_CD, String ADDRESS1, String ADDRESS2, String CREATED_DATE, String UPDATED_DATE, String rowStatus) {
        this.EMP_CD = EMP_CD;
        this.EMP_NM = EMP_NM;
        this.GENDER_CD = GENDER_CD;
        this.JOIN_DATE = JOIN_DATE;
        this.POSITION_CD = POSITION_CD;
        this.DUTY_CD = DUTY_CD;
        this.ROLE_CD = ROLE_CD;
        this.ASSIGNED_TAS = ASSIGNED_TAS;
        this.EMAIL = EMAIL;
        this.ZIP_CD = ZIP_CD;
        this.ADDRESS1 = ADDRESS1;
        this.ADDRESS2 = ADDRESS2;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
        this.rowStatus = rowStatus;
    }
}
