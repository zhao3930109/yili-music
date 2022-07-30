package com.bilitech.yilimusic.entity;


import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;



@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    @GenericGenerator(name="ksuid", strategy = "com.bilitech.yilimusic.utils.KsuidldentifierGenerator")
    private String id;
    @CreationTimestamp
    private Date createdTime;
    private Date updatedTime;
}
