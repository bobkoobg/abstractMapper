
package entity;

public class WinLoseRatio extends AbstractEntity{
    private Integer playerID;
    private Integer opponentID;
    private Boolean Win;

    public WinLoseRatio(Integer id, Integer playerID, Integer opponentID, Boolean Win) {
        this.id = id;
        this.playerID = playerID;
        this.opponentID = opponentID;
        this.Win = Win;
    }

    public WinLoseRatio() {
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public int getOpponentID() {
        return opponentID;
    }

    public void setOpponentID(int opponentID) {
        this.opponentID = opponentID;
    }

    public boolean isWin() {
        return Win;
    }

    public void setWin(boolean Win) {
        this.Win = Win;
    }
    
}
