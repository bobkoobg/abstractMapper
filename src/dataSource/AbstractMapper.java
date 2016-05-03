package dataSource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractMapper<T> {
    //###'Dropping the base Nigga' doin' random OP stuff ;]

    //###Checking table information executeQuery's
    public List<String> overpoweredAbstractMethod(String tableName,
            Connection connection) {
        List<String> listOfFieldNames = new ArrayList<>();
        String SQLFieldNamesString = "Select column_name "
                + "from user_tab_cols "
                + "where table_name=upper('" + tableName + "')";
        PreparedStatement statementForNames = null;
        try {
            statementForNames = connection.prepareStatement(SQLFieldNamesString);
            ResultSet resultSet = statementForNames.executeQuery();
            while (resultSet.next()) {
                listOfFieldNames.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger("\n ***MISTAKE*** in getSQLFieldNames - "
                    + "SQL Exeption(Executing Part): " + ex);
            return null;
        } finally {
            try {
                statementForNames.close();
            } catch (SQLException ex) {
                Logger.getLogger("\n ***MISTAKE*** in getSQLFieldNames - "
                        + "SQL Exeption(Closing Part): " + ex);
                return null;
            }
        }
        return listOfFieldNames;
    }

    //###Import, Update and Delete executeUpdate's 
    public boolean overpoweredAbstractMethod(PreparedStatement actualStatement,
            Connection connect) {

        try {
            actualStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\n ***MISTAKE*** in overpoweredAbstractMethod - "
                    + "SQL Exeption(Execution Part): " + ex);
            return false;
        } finally {
            try {
                actualStatement.close();
            } catch (SQLException sqlE) {
                System.out.println("\n ***MISTAKE*** in overpoweredAbstractMethod - "
                        + "SQL Exeption(Closing Part):" + sqlE);
                return false;
            }
        }
        return true;
    }

    //###Select * (all)executeQuery's
    public <T> ArrayList<T> overpoweredAbstractMethod(PreparedStatement statement,
            Class<T> typeOfCurrentClass, List<Field> fieldsInClasses, Connection connect) {

        List<T> listOfAllRequested = new ArrayList();
        try {
            T currentRequest;
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                currentRequest = typeOfCurrentClass.newInstance();
                //***TO BE ADDED - Check if fields in Classes types == DB Types(down here)
                //ArrayList<String> listOfSQLFieldTypes = getSQTableInformation("data_type", tableName,
                //       builder, connect);
                //System.out.println("listOfSQLFieldTypes : " + listOfSQLFieldTypes.toString());
                //***>>>
                for (int j = 0; j < fieldsInClasses.size(); j++) {
                    fieldsInClasses.get(j).setAccessible(true);
                    int columnIndex = j + 1;
                    if (fieldsInClasses.get(j).getType() == Integer.class) {
                        fieldsInClasses.get(j).set(currentRequest, rs.getInt(columnIndex));
                    } else if (fieldsInClasses.get(j).getType() == String.class) {
                        fieldsInClasses.get(j).set(currentRequest, rs.getString(columnIndex));
                    } else if (fieldsInClasses.get(j).getType() == java.util.Date.class) {
                        fieldsInClasses.get(j).set(currentRequest, new java.util.Date(rs.getDate(columnIndex).getTime()));
                    } else if (fieldsInClasses.get(j).getType() == Boolean.class) {
                        fieldsInClasses.get(j).set(currentRequest, (Boolean) "Y".equals(rs.getString(columnIndex)));
                    }
                    //System.out.println("SIZE IS" + rs.getRow());
                }
                listOfAllRequested.add(currentRequest);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AbstractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<T>) listOfAllRequested;
    }
}
