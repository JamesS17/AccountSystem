package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "AccountMember", description = "A DTO that represents the AccountMember")
public class AccountMemberDto implements Serializable {

    private static final long serialVersionUID = -5056342639586048983L;

    private Long MemID;
    private String MemName;
    private String MemSurname;
    private LocalDate MemDate;
    private Long MemMiles;

    public AccountMemberDto() {
    }

    public AccountMemberDto(Long memID, String memName, String memSurname, LocalDate memDate, Long memMiles) {
        MemID = memID;
        MemName = memName;
        MemSurname = memSurname;
        MemDate = memDate;
        MemMiles = memMiles;
    }

    public AccountMemberDto(AccountMember accountMember){
        this.setMemID(accountMember.getMemID());
        this.setMemName(accountMember.getMemName());
        this.setMemSurname(accountMember.getMemSurname());
        this.setMemDate(accountMember.getMemDate());
        this.setMemMiles(accountMember.getMemMiles());
    }

    @ApiModelProperty(position = 1,
            value = "AccountMember MemID",
            name = "MemID",
            notes = "Uniquely IDs the members account",
            dataType = "java.lang.Long",
            example = "123",
            required = true)
    public Long getMemID() {
        return MemID;
    }

    public AccountMemberDto setMemID(Long memID) {
        MemID = memID;
        return this;
    }

    @ApiModelProperty(position = 2,
            value = "AccountMember Name",
            name = "Name",
            notes = "Name of member",
            dataType = "java.lang.String",
            example = "James",
            required = true)
    public String getMemName() {
        return MemName;
    }

    public AccountMemberDto setMemName(String memName) {
        MemName = memName;
        return this;
    }
    @ApiModelProperty(position = 3,
            value = "AccountMember MemSurname",
            name = "Surname",
            notes = "SurName of member",
            dataType = "java.lang.String",
            example = "Smith",
            required = true)
    public String getMemSurname() {
        return MemSurname;
    }

    public AccountMemberDto setMemSurname(String memSurname) {
        MemSurname = memSurname;
        return this;
    }
    @ApiModelProperty(position = 4,
            value = "AccountMember Creation Date",
            name = "CreationDate",
            notes = "The date on which the account was created",
            dataType = "java.lang.LocalDate",
            example = "2021-01-01",
            required = true)
    public LocalDate getMemDate() {
        return MemDate;
    }

    public AccountMemberDto setMemDate(LocalDate memDate) {
        MemDate = memDate;
        return this;
    }
    @ApiModelProperty(position = 5,
            value = "AccountMember Miles",
            name = "Miles",
            notes = "Members Miles",
            dataType = "java.lang.Long",
            example = "123",
            required = true)
    public Long getMemMiles() {
        return MemMiles;
    }

    public AccountMemberDto setMemMiles(Long memMiles) {
        MemMiles = memMiles;
        return this;
    }

    @JsonIgnore
    public AccountMember getAccountMember(){
        return new AccountMember(getMemID(), getMemName(), getMemSurname(),getMemDate(),getMemMiles());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMemberDto that = (AccountMemberDto) o;
        return Objects.equals(MemID, that.MemID) && Objects.equals(MemName, that.MemName) && Objects.equals(MemSurname, that.MemSurname) && Objects.equals(MemDate, that.MemDate) && Objects.equals(MemMiles, that.MemMiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MemID, MemName, MemSurname, MemDate, MemMiles);
    }

    @Override
    public String toString() {
        return "AccountMemberDto{" +
                "MemID=" + MemID +
                ", MemName='" + MemName + '\'' +
                ", MemSurname='" + MemSurname + '\'' +
                ", MemDate=" + MemDate +
                ", MemMiles=" + MemMiles +
                '}';
    }
}
