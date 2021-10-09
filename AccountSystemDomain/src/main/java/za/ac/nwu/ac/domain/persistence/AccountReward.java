package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "REWARDS", schema = "CMPG323")
public class AccountReward implements Serializable{



    private Long RewardID;
    private AccountMember MemID;
    private String RewardType;
    private LocalDate RewardDateRecieved;
    private Long RewardCost;

    public AccountReward(Long rewardID, AccountMember MemID, String rewardType, LocalDate rewardDateRecieved, Long rewardCost) {
        RewardID = rewardID;
        MemID = MemID;
        RewardType = rewardType;
        RewardDateRecieved = rewardDateRecieved;
        RewardCost = rewardCost;
    }

    public AccountReward() {
    }

    @Id
    @SequenceGenerator(name = "RewardID_value", sequenceName = "CMPG323.RewardID_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RewardID_value")
    @Column(name = "RewardID")
    public Long getRewardID() {
        return RewardID;
    }

    public void setRewardID(Long rewardID) {
        RewardID = rewardID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemID")
    public AccountMember getMemID() {
        return MemID;
    }

    public void setMemID(AccountMember MemID) {
        MemID = MemID;
    }

    @Column(name = "RewardType")
    public String getRewardType() {
        return RewardType;
    }

    public void setRewardType(String rewardType) {
        RewardType = rewardType;
    }

    @Column(name = "RewardDateRecieved")
    public LocalDate getRewardDateRecieved() {
        return RewardDateRecieved;
    }

    public void setRewardDateRecieved(LocalDate rewardDateRecieved) {
        RewardDateRecieved = rewardDateRecieved;
    }

    @Column(name = "RewardCost")
    public Long getRewardCost() {
        return RewardCost;
    }

    public void setRewardCost(Long rewardCost) {
        RewardCost = rewardCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountReward that = (AccountReward) o;
        return Objects.equals(RewardID, that.RewardID) && Objects.equals(MemID, that.MemID) && Objects.equals(RewardType, that.RewardType) && Objects.equals(RewardDateRecieved, that.RewardDateRecieved) && Objects.equals(RewardCost, that.RewardCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RewardID, MemID, RewardType, RewardDateRecieved, RewardCost);
    }

    @Override
    public String toString() {
        return "AccountReward{" +
                "RewardID=" + RewardID +
                ", MemID=" + MemID +
                ", RewardType='" + RewardType + '\'' +
                ", RewardDateRecieved=" + RewardDateRecieved +
                ", RewardCost=" + RewardCost +
                '}';
    }
}
