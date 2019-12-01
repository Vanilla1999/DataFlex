package com.resources;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name ="customer")
public class Car implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
   //@GeneratedValue()
    @Column(name = "customer_id",unique = true)
    private  int id;
    @Column(name = "firstname",unique = false)
    private  String fName;
    @Column(name = "lastname",unique = false)
    private  String lName;

    public int getId(){
        return id;
    }
    public void setId(int id ){
        this.id=id;
    }
    public String getfName(){
        return fName;
    }
    public void setFname(String fname ){
        this.fName=fname;
    }
    public String getLname(){
        return lName;
    }
    public void setlName(String lName ){
        this.lName=lName;
    }


}