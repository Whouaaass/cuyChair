/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paperReview;

import dataAccess.ConnectionSqlitePool;
import dataAccess.paper.RepositorySQLitePaper;
import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.sql.SQLPaperReview;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * @author Juan
 */
public class RepositorySQLitePaperReview implements IRepositoryPaperReview {

    public RepositorySQLitePaperReview() {
    }

    @Override
    public boolean storePaperReview(PaperReview objPaper) {
        String insertPaperReview = "INSERT INTO paperreview(paperId, reviewerId, approved) VALUES (?,?,?)";

        try (Connection conn = ConnectionSqlitePool.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(insertPaperReview);
            pst.setInt(1, objPaper.getPaper().getId());
            pst.setInt(2, objPaper.getReviewer().getUserId());
            pst.setString(3, objPaper.isApproved()? "TRUE" : "FALSE");
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
                newreview.setPaper(repo.getPaperById(rs.getInt(2)));
                aprobed = rs.getString(3).equals("True");
                newreview.setApproved(aprobed);
                PaperReviewList.add(newreview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return PaperReviewList;
    }

    @Override
    public PaperReview getPaperReviewFrom(Paper paper) {
        String selectStatement = "SELECT * FROM PaperReview WHERE paperId = ?";
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(selectStatement);
            pst.setInt(1, paper.getId());
            ResultSet rs = pst.executeQuery();

            if (rs.first()) {
                return createPaperReviewFromRow(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<PaperReview> getPaperReviewsRelatedTo(Conference conference) {
        String selectStatement = "SELECT PaperReview.* from PaperReview inner join Paper on PaperReview.paperId = Paper.id where Paper.conferenceId = ?";
        List<PaperReview> paperReviewList = new ArrayList<>();

        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(selectStatement);
            pst.setInt(1, conference.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                paperReviewList.add(createPaperReviewFromRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperReviewList;
    }

    private PaperReview createPaperReviewFromRow(ResultSet rs) throws SQLException {
        PaperReview pr = new SQLPaperReview();
        pr.setReviewId(rs.getInt("id"));
        pr.setApproved(rs.getString("approved").equals("TRUE"));
        return pr;
    }

}
