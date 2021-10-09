package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER_TABLE", schema = "CMPG323")
public class AccountMember implements Serializable{

    //private static final long serialVersionUID = ;



    private Long MemID;
    private String MemName;
    private String MemSurname;
    private LocalDate MemDOB;
    private String MemEmail;
    private String MemNumber;
    private Set<AccountReward> accountRewards;
    private Set<AccountMiles> accountMiles;
    private Set<AccountGameBoard> accountGameBoards;

    public AccountMember(Long memID, String memName, String memSurname, LocalDate memDOB, String memEmail, String memNumber) {
        MemID = memID;
        MemName = memName;
        MemSurname = memSurname;
        MemDOB = memDOB;
        MemEmail = memEmail;
        MemNumber = memNumber;
    }

    public AccountMember() {
    }

    @Id
    @SequenceGenerator(name = "MemID_value", sequenceName = "CMPG323.MemID_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemID_value")
    @Column(name = "MemID")
    public Long getMemID() {
        return MemID;
    }

    public void setMemID(Long memID) {
        MemID = memID;
    }
    @Column(name = "MemName")
    public String getMemName() {
        return MemName;
    }

    public void setMemName(String memName) {
        MemName = memName;
    }
    @Column(name = "MemSurname")
    public String getMemSurname() {
        return MemSurname;
    }

    public void setMemSurname(String memSurname) {
        MemSurname = memSurname;
    }
    @Column(name = "MemDOB")
    public LocalDate getMemDOB() {
        return MemDOB;
    }

    public void setMemDOB(LocalDate memDOB) {
        MemDOB = memDOB;
    }

    @Column(name = "MemEmail")
    public String getMemEmail() {
        return MemEmail;
    }

    public void setMemEmail(String memEmail) {
        MemEmail = memEmail;
    }

    @Column(name = "MemNumber")
    public String getMemNumber() {
        return MemNumber;
    }

    public void setMemNumber(String memNumber) {
        MemNumber = memNumber;
    }

    @OneToMany(targetEntity = AccountReward.class, fetch = FetchType.LAZY, mappedBy = "MemID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountReward> getAccountRewards() {
        return accountRewards;
    }

    public void setAccountRewards(Set<AccountReward> accountRewards){
        this.accountRewards = accountRewards;
    }

    @OneToOne(targetEntity = AccountGameBoard.class, fetch = FetchType.LAZY, mappedBy = "MemID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountGameBoard> getGameBoards() {
        return accountGameBoards;
    }
    public void setAccountGameBoards(Set<AccountGameBoard> accountGameBoards){
        this.accountGameBoards = accountGameBoards;
    }

    @OneToOne(targetEntity = AccountMiles.class, fetch = FetchType.LAZY, mappedBy = "MemID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountMiles> getAccountMiles() {
        return accountMiles;
    }
    public void setAccountMiles(Set<AccountMiles> accountMiles){
        this.accountMiles = accountMiles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMember that = (AccountMember) o;
        return Objects.equals(MemID, that.MemID) && Objects.equals(MemName, that.MemName) && Objects.equals(MemSurname, that.MemSurname) && Objects.equals(MemDOB, that.MemDOB) && Objects.equals(MemEmail, that.MemEmail) && Objects.equals(MemNumber, that.MemNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MemID, MemName, MemSurname, MemDOB, MemEmail, MemNumber);
    }

    @Override
    public String toString() {
        return "AccountMember{" +
                "MemID=" + MemID +
                ", MemName='" + MemName + '\'' +
                ", MemSurname='" + MemSurname + '\'' +
                ", MemDOB=" + MemDOB +
                ", MemEmail='" + MemEmail + '\'' +
                ", MemNumber='" + MemNumber + '\'' +
                '}';
    }
}


