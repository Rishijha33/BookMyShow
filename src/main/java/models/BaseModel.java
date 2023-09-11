package models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
/*
Mapped superclass - Means that all the classes inheriting this class
will have the attributes of this class as columns in their tables
*/
public class BaseModel {
    @Id //Defines that id will be the primary ley
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will autoincrement the ID
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;//we can use these for audit data

}
