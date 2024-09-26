/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paper;

import dataAccess.ConnectionSqlitePool;
import dataAccess.user.RepositorySQLiteUser;
import domain.Paper;
import domain.User;

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
            String insertPaper = "INSERT INTO Paper VALUES(?, ?, ?, ?)";

            PreparedStatement pst=conn.prepareStatement(insertPaper);
            pst.setInt(1, objPaper.getId());
            pst.setString(2, objPaper.getTitle());
            pst.setString(3, objPaper.getDescription());
            pst.setInt(4, objPaper.getAuthor().getUserId());
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
                newPaper.setId(rs.getInt(1));
                newPaper.setTitle(rs.getString(2));
                newPaper.setDescription(rs.getString(3));
                newPaper.setAuthor(repoUser.getUserById(rs.getInt(4)));
                List.add(newPaper);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return List;
    }

    @Override
    public Paper getPaperById(int paperId) {
        try (Connection connection=ConnectionSqlitePool.getConnection()){

            String selectId = "SELECT * FROM paper WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(selectId);
            pst.setInt(1, paperId);
            RepositorySQLiteUser repo = new RepositorySQLiteUser();
            ResultSet rs = pst.executeQuery();

            Paper newPaper = new Paper(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    repo.getUserById(rs.getInt("userId"))
            );

            if (rs.wasNull()) {
                return null;
            }

            return newPaper;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initDatabase(){
        try (Connection conn= ConnectionSqlitePool.getConnection()){
            String tablePaper="CREATE TABLE IF NOT EXISTS Paper(\n "
                    +"id number NOT NULL PRIMARY KEY,\n"
                    +"title text NOT NULL,\n"
                    +"description text NOT NULL,\n"
                    +"userId number NOT NULL,\n"
                    +"FOREIGN KEY (userId) REFERENCES User(id)\n"
                    +");";

            Statement st= conn.createStatement();
            st.execute(tablePaper);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
