package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MILES", schema = "CMPG323")
public class AccountMiles implements Serializable{

    private Long MemID;
    private Long TotalMiles;

    public AccountMiles(Long memID, Long totalMiles) {
        MemID = memID;
        TotalMiles = totalMiles;
    }

    public AccountMiles() {
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemID")
    public Long getMemID() {
        return MemID;
    }

    public void setMemID(Long memID) {
        MemID = memID;
    }
    @Column(name = "TotalMiles")
    public Long getTotalMiles() {
        return TotalMiles;
    }

    public void setTotalMiles(Long totalMiles) {
        TotalMiles = totalMiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMiles that = (AccountMiles) o;
        return Objects.equals(MemID, that.MemID) && Objects.equals(TotalMiles, that.TotalMiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MemID, TotalMiles);
    }

    @Override
    public String toString() {
        return "AccountMiles{" +
                "MemID=" + MemID +
                ", TotalMiles=" + TotalMiles +
                '}';
    }
}
