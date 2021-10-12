package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER_TABLE", schema = "HR")
public class AccountMember implements Serializable{

    //private static final long serialVersionUID = ;
    private static final long serialVersionUID = 9011408239159707013L;
    private Long MemID;
    private String MemName;
    private String MemSurname;
    private LocalDate MemDate;
    private Long MemMiles;

    public AccountMember(Long memID, String memName, String memSurname, LocalDate memDate, Long memMiles) {
        MemID = memID;
        MemName = memName;
        MemSurname = memSurname;
        MemDate = memDate;
        MemMiles = memMiles;
    }

    public AccountMember() {
    }

    @Id
    @SequenceGenerator(name = "MemID_value", sequenceName = "HR.MemID_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemID_value")
    @Column(name = "MEMID")
    public Long getMemID() {
        return MemID;
    }

    public void setMemID(Long memID) {
        MemID = memID;
    }
    @Column(name = "MEMNAME")
    public String getMemName() {
        return MemName;
    }

    public void setMemName(String memName) {
        MemName = memName;
    }
    @Column(name = "MEMSURNAME")
    public String getMemSurname() {
        return MemSurname;
    }

    public void setMemSurname(String memSurname) {
        MemSurname = memSurname;
    }
    @Column(name = "MEMDATE")
    public LocalDate getMemDate() {
        return MemDate;
    }

    public void setMemDate(LocalDate memDate) {
        MemDate = memDate;
    }
    @Column(name = "MEMMILES")
    public Long getMemMiles() {
        return MemMiles;
    }

    public void setMemMiles(Long memMiles) {
        MemMiles = memMiles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMember that = (AccountMember) o;
        return Objects.equals(MemID, that.MemID) && Objects.equals(MemName, that.MemName) && Objects.equals(MemSurname, that.MemSurname) && Objects.equals(MemDate, that.MemDate) && Objects.equals(MemMiles, that.MemMiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MemID, MemName, MemSurname, MemDate, MemMiles);
    }

    @Override
    public String toString() {
        return "AccountMember{" +
                "MEMID=" + MemID +
                ", MEMNAME='" + MemName + '\'' +
                ", MEMSURNAME='" + MemSurname + '\'' +
                ", MEMDATE=" + MemDate +
                ", MEMMILES=" + MemMiles +
                '}';
    }
}


