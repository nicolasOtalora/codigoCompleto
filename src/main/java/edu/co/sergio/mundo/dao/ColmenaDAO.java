package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.ColmenaVO;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColmenaDAO{

    public ArrayList consultaTorta() {

        
        int total = 0;
        ArrayList datos = null;

        try {
            String query = "select PanalAlimento from Colmena where id = 1;";
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            datos = new ArrayList();

            while (rs.next()) {
                

                total = rs.getInt("PanalAlimento");
                datos.add(total);
            }

        } catch (SQLException e) {
        }

        return datos;
    }

    public ArrayList consultaBarras() {

       
        int id = 0;
        int kilos = 0;
        ArrayList datos = null;

        try {
            String query = "select id,kilos from Colmena group by id;";
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
                datos = new ArrayList();

            while (rs.next()) {
                id = rs.getInt("id");

                
                kilos = rs.getInt("kilos");
                datos.add(id);
                datos.add(kilos);
            }

        } catch (SQLException e) {
        }

        return datos;

    }

    
}
