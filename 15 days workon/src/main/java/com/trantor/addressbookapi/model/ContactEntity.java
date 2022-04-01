package com.trantor.addressbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTACT_TABLE")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Contact_Id")
    private Long contactId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Column(name = "Created_By")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Updated_By")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "Updated_On")
    private Date updatedDate;

    @Column(name = "Is_Active")
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Contact_Id")
    private List<MobileEntity> mobileEntities;

}
