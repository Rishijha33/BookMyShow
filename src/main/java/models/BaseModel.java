package models;

import java.util.Date;

public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;             //we can use these for audit data

}
