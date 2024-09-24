package test;

import dataAccess.user.RepositoryArrayListUser;
import drivers.UserStoreService;
import views.ViewLogIn;

public class Test {
    public static void main(String[] args) {
        RepositoryArrayListUser objRepositoryArrayListUser = new RepositoryArrayListUser();
        UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
        ViewLogIn objViewLogIn=new ViewLogIn(objUserStoreService);
        objViewLogIn.setVisible(true);
        objViewLogIn.setLocationRelativeTo(null);
    }
}
