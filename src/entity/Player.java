
package entity;

import java.util.Date;

public class Player extends AbstractEntity{
     private String playerName;
     private Date dateOfBirth;

    public Player(int playerID, String playerName, Date dateOfBirth) {
        this.id = playerID;
        this.playerName = playerName;
        this.dateOfBirth = dateOfBirth;
    }

    public Player() {
    }
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
