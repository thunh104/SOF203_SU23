package model;

import java.util.ArrayList;
import java.util.List;

public class UserLogin {

    List<User> listu = new ArrayList<>();

    public UserLogin() {
        listu.add(new User("HoaiThu", "1234", "admin"));
        listu.add(new User("ThuTrang", "1234", "admin"));
        listu.add(new User("QuangHuy", "5678", "user"));
        listu.add(new User("VietHoang", "5678", "user"));
    }

    public boolean checkData(String userName, String passWord) {
        for (User u : listu) {
            if (u.getUserName().equals(userName) && u.getPassWord().equals(passWord)) {
                return true;
            }
        }
        return false;
    }
}
