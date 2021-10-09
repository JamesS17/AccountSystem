package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REWARDS", schema = "CMPG323")
public class AccountGameBoard implements Serializable{

    private Long GameID;
    private AccountMember MemID;
    private AccountGameTile TileID;
    private Long NumOfPlays;

    public AccountGameBoard(Long gameID, AccountMember memID, AccountGameTile tileID, Long numOfPlays) {
        GameID = gameID;
        MemID = memID;
        TileID = tileID;
        NumOfPlays = numOfPlays;
    }

    public AccountGameBoard() {
    }

    @Id
    @SequenceGenerator(name = "GameID_value", sequenceName = "CMPG323.GameID_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GameID_value")
    @Column(name = "GameID")
    public Long getGameID() {
        return GameID;
    }

    public void setGameID(Long gameID) {
        GameID = gameID;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemID")
    public AccountMember getMemID() {
        return MemID;
    }

    public void setMemID(AccountMember memID) {
        MemID = memID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tileID")
    public AccountGameTile getTileID() {
        return TileID;
    }

    public void setTileID(AccountGameTile tileID) {
        TileID = tileID;
    }

    @Column(name = "numOfPlays")
    public Long getNumOfPlays() {
        return NumOfPlays;
    }

    public void setNumOfPlays(Long numOfPlays) {
        NumOfPlays = numOfPlays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountGameBoard that = (AccountGameBoard) o;
        return Objects.equals(GameID, that.GameID) && Objects.equals(MemID, that.MemID) && Objects.equals(TileID, that.TileID) && Objects.equals(NumOfPlays, that.NumOfPlays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GameID, MemID, TileID, NumOfPlays);
    }

    @Override
    public String toString() {
        return "AccountGameBoard{" +
                "GameID=" + GameID +
                ", MemID=" + MemID +
                ", TileID=" + TileID +
                ", NumOfPlays=" + NumOfPlays +
                '}';
    }
}
