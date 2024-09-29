/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Repositorio que guarda los usuarios en memoria por medio de un ArrayList
 * @author Frdy
 */
public class RepositoryArrayListUser implements IRepositoryUser {
    
    private final ArrayList<User> userList;
    private final AtomicInteger indexCounter;
    
    /**
     * Genera una instancia del repositorio
     */
    public RepositoryArrayListUser() {
        indexCounter = new AtomicInteger(0);
        userList = new ArrayList<>();
    }
    
    @Override
    public boolean storeUser(User objUser) {
        objUser.setUserId(indexCounter.getAndIncrement());
        return userList.add(objUser);
    }

    @Override
    public List<User> listUsers() {
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getUserEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean modifyUser(int userId, String name, String lastName, String password, String description) {
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUserId()==userId){
                userList.get(i).setUserName(name);
                userList.get(i).setUserLastName(lastName);
                userList.get(i).setUserPassword(password);
                userList.get(i).setDescription(description);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> listUsersRelatedTo(Conference conference) {
        List<User> newList = new ArrayList<>();
        for (ConferenceParticipation participation : conference.getParticipations()) {
            newList.add(participation.getParticipant());
        }
        return newList;
    }

    @Override
    public List<User> listUsersRelatedTo(Conference conference, ConferenceParticipation.Role role) {
        List<User> newList = new ArrayList<>();
        for (ConferenceParticipation participation : conference.getParticipations()) {
            if (participation.getRole() == role) {
                newList.add(participation.getParticipant());
            }
        }
        return newList;
    }

    @Override
    public User getUserOrganizerOf(Conference conference) {

        return conference.getConferenceOrganizer();
    }

    @Override
    public User getReviewerOf(PaperReview paperReview) {
        return paperReview.getReviewer();
    }

    @Override
    public User getAuthorOf(Paper paper) {
        return paper.getAuthor();
    }
}
