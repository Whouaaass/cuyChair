/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paper;

import dataAccess.ConnectionSqlitePool;
import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.user.RepositorySQLiteUser;
import domain.Conference;
import domain.InfoJob;
import domain.Paper;
import domain.PaperReview;
import domain.sql.SQLPaper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author julia
 */
public class RepositorySQLitePaper implements IRepositoryPaper {

    public RepositorySQLitePaper() {}

    @Override
    public boolean storePaper(Paper objPaper) {

        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            String insertPaper = "INSERT INTO Paper(title, description, userId, conferenceId) VALUES(?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(insertPaper);
            pst.setString(1, objPaper.getTitle());
            pst.setString(2, objPaper.getDescription());
            pst.setInt(3, objPaper.getAuthor().getUserId());
            pst.setInt(4, objPaper.getConference().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Lista los papers
     *
     * @return lista de papers
     */
    @Override
    public List<Paper> listPaper() {
        RepositorySQLiteUser repoUser = new RepositorySQLiteUser();
        ArrayList<Paper> List = new ArrayList<>();
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            String listPaper = "SELECT * FROM Paper";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(listPaper);
            while (rs.next()) {
                Paper newPaper = new Paper();
                newPaper.setId(rs.getInt(1));
                newPaper.setTitle(rs.getString(2));
                newPaper.setDescription(rs.getString(3));
                newPaper.setAuthor(repoUser.getUserById(rs.getInt(4)));
                List.add(newPaper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List;
    }

    @Override
    public Paper getPaperById(int paperId) {
        Paper newPaper = null;
        try (Connection connection = ConnectionSqlitePool.getConnection()) {

            String selectId = "SELECT * FROM paper WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(selectId);
            pst.setInt(1, paperId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                newPaper = createPaperFromRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newPaper;
    }

    @Override
    public List<Paper> listPapersFrom(Conference conference) {
        String selectStatement = "SELECT * from Paper where conferenceId = ?";
        List<Paper> newPapers = new ArrayList<>();
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(selectStatement);
            pst.setInt(1, conference.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                newPapers.add(createPaperFromRow(rs));
            }
            return newPapers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Paper getPaperOfReview(PaperReview paperReview) {
        String selectStatement = "SELECT Paper.* from Paper Inner join PaperReview ON Paper.id = PaperReview.paperId where PaperReview.id = ?";
        Paper newPaper = null;
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(selectStatement);
            pst.setInt(1, paperReview.getReviewId());
            ResultSet rs = pst.executeQuery();
            newPaper = createPaperFromRow(rs);
            if (rs.wasNull()) {
                return null;
            }
            return newPaper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InfoJob getInfoJobs() {
        String select="SELECT * FROM Paper ORDER BY id DESC LIMIT 1";
        InfoJob info=new InfoJob();
        RepositorySQLiteConference repoConfe=new RepositorySQLiteConference();
        RepositorySQLiteUser repoUser=new RepositorySQLiteUser();
        try(Connection conn = ConnectionSqlitePool.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(select);
                info.setTitlePaper(rs.getString("title"));
                info.setDescriptionPaper(rs.getString("description"));
                info.setNameConference(repoConfe.getConferenceById(Integer.parseInt(rs.getString("conferenceId"))).getTitle());
                info.setNameAuthor(repoUser.getUserById(Integer.parseInt(rs.getString("userId"))).getUserName());

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return info;
    }

    private Paper createPaperFromRow(ResultSet rs) throws SQLException {
        Paper newPaper = new SQLPaper();
        newPaper.setId(rs.getInt("id"));
        newPaper.setTitle(rs.getString("title"));
        newPaper.setDescription(rs.getString("description"));
        //TODO Añadir documentLink
        return newPaper;
    }

}
