package base;

import dataSource.ConnectionClass;
import dataSource.AbstractMapper;
import dataSource.PrepareStatement;
import entity.AbstractEntity;
import entity.EntityClassExplorer;

import entity.Player;
import entity.Skill;
import entity.WinLoseRatio;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KnowledgeRecap {

    private final Connection connection;

    private KnowledgeRecap() {
        connection = ConnectionClass.getConnection();
    }

    private void haveSomeFun() throws IllegalArgumentException, IllegalAccessException {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        java.util.Date dateOfBirthDEMO = new java.util.Date(Calendar.getInstance().getTimeInMillis());
        Player p = new Player(93, "Datenqmam", dateOfBirthDEMO);
        ArrayList<Player> ae = new ArrayList();
        ae.add(p);
//        AbstractMapper pm = new AbstractMapper();
//        pm.overpoweredAbstractMethod(Player.class, ae, "A_ChessGame_Players", connection);

        Skill s = new Skill(29, "Damage1");
        ArrayList<Skill> sl = new ArrayList();
        sl.add(s);
//        AbstractMapper pm = new AbstractMapper();
//        pm.overpoweredAbstractMethod(Skill.class, sl, "A_ChessGame_Skills", connection);

        WinLoseRatio wlr = new WinLoseRatio(2, 3, 23, true);
        ArrayList<WinLoseRatio> actualArrayList = new ArrayList();
        actualArrayList.add(wlr);
        AbstractMapper pm = new AbstractMapper();
        //pm.overpoweredAbstractMethod("create", "A_ChessGame_Player", ae, Player.class, connection);
        //pm.delete("delete", "A_ChessGame_Player", 98, connection);

        EntityClassExplorer ece = new EntityClassExplorer();
        List<Field> fields = ece.retrieveFieldsFromEntity(Player.class);
//        ArrayList<Player> listOfPlayers = pm.overpoweredAbstractMethod("select *", "A_ChessGame_Player", Player.class, fields, connection);


        PrepareStatement ps = new PrepareStatement();
//        PreparedStatement rps = ps.generateSQLString("insert", "A_ChessGame_Player", fields, ae, connection);
//        pm.overpoweredAbstractMethod(rps, sl, connection);

        List<String> listofsqlinfo = pm.overpoweredAbstractMethod("A_ChessGame_Player", connection);
//        PreparedStatement rpsupd = ps.generateSQLString("update", "A_ChessGame_Player", ae, fields, listofsqlinfo, connection);
//        pm.overpoweredAbstractMethod(rpsupd, connection);
        
//        PreparedStatement rpsdel = ps.generatesQLString("delete", "A_ChessGame_Player", 7, listofsqlinfo, connection);
//        pm.overpoweredAbstractMethod(rpsdel, connection);
        
        PreparedStatement rpsselall = ps.generateSQLString("select *", "A_ChessGame_Player", connection);
        ArrayList<Player> listOfPlayers = pm.overpoweredAbstractMethod(rpsselall, Player.class, fields, connection);
        for (int i = 0; i < listOfPlayers.size(); i++) {
            Integer id = listOfPlayers.get(i).getId();
            String name = listOfPlayers.get(i).getPlayerName();
            Date date = listOfPlayers.get(i).getDateOfBirth();
            System.out.println("ArrayList on possition " + i + " :" + id + ", " + name + ", " + date);
        }

    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        new KnowledgeRecap().haveSomeFun();
    }
}
