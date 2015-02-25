package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by golans on 5/19/2014.
 * Hold Mongo DB user data from DB-OfflineDebugger Collection-Users
 */
@XmlRootElement(name="Users")
@JsonRootName("Users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users{
    private String username;

    public Users() {  }

    public Users(String username)
    {
        this.username=username;
    }

    @XmlAttribute(name = "username")
    @JsonProperty("username")
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    @Override
    public boolean equals(Object obj) {
        return this.username.equals(((Users)obj).getUsername());
    }

    public String toString() {
        return new StringBuilder(" username : ").append(this.username).toString();
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }
}
