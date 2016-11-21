//package ru.kpfu.Buzukina.daoImpl;
//
//import ru.kpfu.Buzukina.dao.CookieDAO;
//import ru.kpfu.Buzukina.entities.User;
//import ru.kpfu.Buzukina.helpers.ConnectionSingleton;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * Created by taa on 13.11.16.
// */
//public class CookieDAOImpl  implements CookieDAO {
//    private Connection conn;

////    public MyCookie getCookie(User user) {
////        try{
////            conn = ConnectionSingleton.getConnection();
////            Statement st = conn.createStatement();
////            ResultSet rs = st.executeQuery("select password from coookies where user='" + user.getId() + "'");
////            rs.next();
////
////            MyCookie cookie = new MyCookie(
////                    (long)rs.getInt("id"),
////                    rs.getString("cookie"),
////                    rs.getString("cookie_token"),
////                    (long)rs.getInt("user")
////            );
////
////            return cookie;
////
////
////        } catch (SQLException e) {
////            return  null;
////        }
////    }
////    public boolean insertCookie(MyCookie cookie){
////        try{
////            conn = ConnectionSingleton.getConnection();
////            Statement st = conn.createStatement();
////            int rs = st.executeUpdate("insert into cookies (\"cookie\", \"password_token\", \"user\") values('" + cookie.getCookie() + "', '" + cookie.getCookieToken() + "', '" + (int)cookie.getUser() + "')");
////
////            return rs == 1;
////
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return false;
////
////        }
////    }
//
//    @Override
//    public String getPassword(String password_token) {
//        try{
//            conn = ConnectionSingleton.getConnection();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("select users.password from users join cookies on users.id = cookies.user where password_token='"
//                    + password_token + "'");
//            rs.next();
//            String password = rs.getString("password");
//            return password;
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}
