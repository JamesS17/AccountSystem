package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "REWARDS", schema = "CMPG323")
public class AccountGameTile implements Serializable{

    private Long TileID;
    private Long TilePiece;
    private Long MilesEarned;
    private Set<AccountGameBoard> accountGameBoards;

    public AccountGameTile(Long tileID, Long tilePiece, Long milesEarned) {
        TileID = tileID;
        TilePiece = tilePiece;
        MilesEarned = milesEarned;
    }

    public AccountGameTile() {
    }

    @Id
    @SequenceGenerator(name = "TileID_value", sequenceName = "CMPG323.TileID_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TileID_value")
    @Column(name = "TileID")
    public Long getTileID() {
        return TileID;
    }

    public void setTileID(Long tileID) {
        TileID = tileID;
    }

    @Column(name = "TilePiece")
    public Long getTilePiece() {
        return TilePiece;
    }

    public void setTilePiece(Long tilePiece) {
        TilePiece = tilePiece;
    }

    @Column(name = "milesEarned")
    public Long getMilesEarned() {
        return MilesEarned;
    }

    public void setMilesEarned(Long milesEarned) {
        MilesEarned = milesEarned;
    }

    @OneToMany(targetEntity = AccountGameBoard.class, fetch = FetchType.LAZY, mappedBy = "tileID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountGameBoard> getGameBoards() {
        return accountGameBoards;
    }
    public void setAccountGameBoards(Set<AccountGameBoard> accountGameBoards){
        this.accountGameBoards = accountGameBoards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountGameTile that = (AccountGameTile) o;
        return Objects.equals(TileID, that.TileID) && Objects.equals(TilePiece, that.TilePiece) && Objects.equals(MilesEarned, that.MilesEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TileID, TilePiece, MilesEarned);
    }

    @Override
    public String toString() {
        return "AccountGameTile{" +
                "TileID=" + TileID +
                ", TilePiece=" + TilePiece +
                ", MilesEarned=" + MilesEarned +
                '}';
    }
}
