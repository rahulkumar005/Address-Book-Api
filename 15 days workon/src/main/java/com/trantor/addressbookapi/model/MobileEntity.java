package com.trantor.addressbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "MOBILE_TABLE")
public class MobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Mobile_Id")
    private Integer mobileId;
    @Column(name = "Mobile_Number")
    private String mobileNumber;
    @Column(name = "Country_Code")
    private String countryCode;
    @Column(name = "Type")
    private String type;
    @Column(name = "Created_By")
    private String createdBy;
    @CreationTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Updated_By")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name = "Updated_Date")
    private Date updatedDate;


}
