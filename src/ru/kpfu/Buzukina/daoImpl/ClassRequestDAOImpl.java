package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.dao.ClassRequestDAO;
import ru.kpfu.Buzukina.entities.ClassRequest;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by taa on 17.11.16.
 */
public class ClassRequestDAOImpl implements ClassRequestDAO {
    private Connection conn;

    @Override
    public boolean insertClassRequest(ClassRequest classRequest) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into class_requests(\"name\", \"email\", \"phone\") values('" + classRequest.getName()
                    + "','" + classRequest.getEmail() + "','" + classRequest.getPhone() + "');");
            if(rs != null) {
                return true;
            }else{
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
