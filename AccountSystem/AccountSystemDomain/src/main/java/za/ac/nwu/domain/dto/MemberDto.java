package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "Member", description = "A DTO that represents the Member")
public class MemberDto implements Serializable
{

    private String email;
    private String fName;
    private String lName;
    private LocalDate creationDate;

    public MemberDto()
    {
    }

    public MemberDto(String email, String fName, String lName, LocalDate creationDate)
    {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.creationDate = creationDate;
    }

    public MemberDto(Member member)
    {
        this.setfName(member.getfName());
        this.setlName(member.getlName());
        this.setCreationDate(member.getCreationDate());
        this.setEmail(member.getEmail());
    }

    @ApiModelProperty(position = 1,
            value = "Member Email",
            name = "Email",
            notes = "Uniquely identifies the account of a user",
            dataType = "java,lang.String",
            example = "s.storm4321@gmail.com",
            required = true)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @ApiModelProperty(position = 2,
            value = "Member Fits Name",
            name = "First Name",
            notes = "The first name of the Member",
            dataType = "java.lang.String",
            example = "Stefan",
            required = true)
    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    @ApiModelProperty(position = 3,
            value = "Member Last Name",
            name = "Last Name",
            notes = "The last name of the Member",
            dataType = "java.lang.String",
            example = "Storm",
            required = true)
    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    @ApiModelProperty(position = 4,
            value = "Member Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the Member was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true)
    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MemberDto that = (MemberDto) o;
        return Objects.equals(email, that.email) && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public Member getMember()
    {
        return new Member(getEmail(), getfName(), getlName(), getCreationDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email, fName, lName, creationDate);
    }

    @Override
    public String toString()
    {
        return "MemberDto{" +
                "email='" + email + '\'' +
                ", firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
