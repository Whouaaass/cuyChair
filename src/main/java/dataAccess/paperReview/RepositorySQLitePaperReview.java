/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paperReview;

import dataAccess.ConnectionSqlitePool;
import dataAccess.paper.RepositorySQLitePaper;
import domain.PaperReview;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 *
 * @author Juan
 */
public class RepositorySQLitePaperReview implements IRepositoryPaperReview {

    public RepositorySQLitePaperReview() {
        initDatabase();
    }

    @Override
    public boolean storePaperReview(PaperReview objPaper) {
        String insertPaperReview = "INSERT INTO paperreview VALUES (?,?,?)";

        try (Connection conn = ConnectionSqlitePool.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(insertPaperReview);
            pst.setInt(1, objPaper.getReviewId());
            pst.setInt(2, objPaper.getObjPaper().getId());
            pst.setString(3, objPaper.isAprobed() == TRUE ? "True" : "False");
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PaperReview> listPaperReview() {
        ArrayList<PaperReview> PaperReviewList = new ArrayList<>();
        String listRevew = "SELECT * FROM PaperReview";

        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(listRevew);
            RepositorySQLitePaper repo = new RepositorySQLitePaper();
            boolean aprobed;

            while (rs.next()) {
                PaperReview newreview = new PaperReview();
                newreview.setReviewId(rs.getInt(1));
                newreview.setObjPaper(repo.getPaperById(rs.getInt(2)));
                aprobed = rs.getString(3).equals("True");
                newreview.setAprobed(aprobed);
                PaperReviewList.add(newreview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return PaperReviewList;
    }

    private void initDatabase() {
        String tablePaperReview = "CREATE TABLE IF NOT EXISTS PaperReview (\n"
                + "id integer PRIMARY KEY,\n"
                + "paperId integer NOT NULL,\n"
                + "approved text NOT NULL,\n "
                + "CHECK(approved in('True','False')),\n"
                + "FOREIGN KEY (paperId) REFERENCES Paper(id)\n"
                + ");";
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            Statement st = conn.createStatement();
            st.executeUpdate(tablePaperReview);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
