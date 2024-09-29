package dataAccess.conferenceParticipation;

import dataAccess.ConnectionSqlitePool;
import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorySQLiteConferenceParticipation implements IRepositoryConferenceParticipation{
    @Override
    public List<ConferenceParticipation> getParticipationsOf(User user) {
        List<ConferenceParticipation> participations = new ArrayList<ConferenceParticipation>();
        String selectStatement = "SELECT * FROM UserConference where userId = ?";
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(selectStatement);
            statement.setInt(1, user.getUserId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                participations.add(createConferenceParticipationFromRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participations;
    }

    @Override
    public List<ConferenceParticipation> getParticipationsOf(Conference conference) {
        List<ConferenceParticipation> participations = new ArrayList<>();
        String selectStatement = "SELECT * FROM UserConference where conferenceId = ?";
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(selectStatement);
            statement.setInt(1, conference.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                participations.add(createConferenceParticipationFromRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participations;
    }

    private ConferenceParticipation createConferenceParticipationFromRow(ResultSet rs) throws SQLException {
        ConferenceParticipation conferenceParticipation = new ConferenceParticipation(
                null,
                null,
                ConferenceParticipation.Role.valueOf(rs.getInt("rol")) );

        return conferenceParticipation;
    }
}
