/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paper;

import dataAccess.ConnectionSqlitePool;
import dataAccess.user.RepositorySQLiteUser;
import domain.Paper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositorySQLitePaper implements IRepositoryPaper{

    public RepositorySQLitePaper() {
        initDatabase();
    }
    @Override
    public boolean storePaper(Paper objPaper) {

        try (Connection conn=ConnectionSqlitePool.getConnection()){
            String insertPaper = "INSERT INTO Paper VALUES(?, ?, ?)";

            PreparedStatement pst=conn.prepareStatement(insertPaper);
            pst.setString(1, objPaper.getFldTitle());
            pst.setString(2, objPaper.getFldDescription());
            pst.setString(3, objPaper.getFldAutor().getUserEmail());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Lista los papers
     * @return lista de papers
     */
    @Override
    public List<Paper> listPaper() {
        RepositorySQLiteUser repoUser=new RepositorySQLiteUser();
        ArrayList<Paper> List=new ArrayList<>();
        try (Connection conn=ConnectionSqlitePool.getConnection()){
            String listPaper = "SELECT * FROM Paper";

            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(listPaper);
            while(rs.next()){
                Paper newPaper=new Paper();
                newPaper.setFldTitle(rs.getString(1));
                newPaper.setFldDescription(rs.getString(2));
                newPaper.setFldAutor(repoUser.getUserByEmail(rs.getString(3)));
                List.add(newPaper);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return List;
    }

    public void initDatabase(){
        try (Connection conn= ConnectionSqlitePool.getConnection()){
            String tablePaper="CREATE TABLE IF NOT EXISTS Paper(\n "
                    +"fldId number NOT NULL PRIMARY KEY,\n"
                    +"fldTitle text NOT NULL,\n"
                    +"fldDescription text NOT NULL,\n"
                    +"fldUserId number NOT NULL,\n"
                    +"FOREIGN KEY (fldUserId) REFERENCES User(fldId)\n"
                    +");";

            Statement st= conn.createStatement();
            st.execute(tablePaper);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
