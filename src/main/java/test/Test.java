package test;

import dataAccess.user.RepositorySQLiteUser;
import drivers.UserStoreService;
import views.ViewLogIn;

public class Test {
    public static void main(String[] args) {
        RepositorySQLiteUser objRepositoryArrayListUser = new RepositorySQLiteUser();
        UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
        ViewLogIn objViewLogIn=new ViewLogIn(objUserStoreService);
        objViewLogIn.setVisible(true);
        objViewLogIn.setLocationRelativeTo(null);
    }
}
