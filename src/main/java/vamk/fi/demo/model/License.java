package vamk.fi.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

import javax.persistence.*;

@Entity(
        name="License"      //the name of the class
)
@Table(name ="license")     //the name of the table
public class License {

    @SequenceGenerator(name = "license_sequence",       //in case if ID is not mentioned it be generated automatically 
            sequenceName ="license_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "license_sequence"
    )
    @Id

    @Column( name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "expiresAt")
    private String expiresAt;
    @Column(name = "queriedAt")
    private String queriedAt;

    public License () {

    }

    public License(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("expiresAt") String expiresAt,
                @JsonProperty("queriedAt") String queriedAt) {     //JsonProperty to recognize the variable

        //constructors
        this.id = id;       
        this.name = name;
        this.expiresAt = expiresAt;
        this.queriedAt = queriedAt;
    }



    //constructors for get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getExpiresAt() {
        return expiresAt;
    }

    public void  setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    } 

    public String getQueriedAt() {
        return queriedAt;
    }

    public void setQueriedAt(String queriedAt) {
        this.queriedAt = queriedAt;
    }
}
