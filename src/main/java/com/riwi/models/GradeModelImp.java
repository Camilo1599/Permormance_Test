package com.riwi.models;

import com.riwi.entities.GradesEntity;
import com.riwi.persistences.configDB.MysqlConfigDB;
import com.riwi.persistences.imodels.IGradeModel;
import com.riwi.persistences.util.enums.gradeType;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeModelImp implements IGradeModel {

    @Override
    public GradesEntity create(GradesEntity gradesEntity){
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();
        try{
            String sql = "INSERT INTO grades (grade, grade_type, registration_id) VALUES (?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, gradesEntity.getGrade());
            preparedStatement.setString(2, gradesEntity.getGrade_type().name());
            preparedStatement.setInt(3, gradesEntity.getRegistration_id());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Calificacion creada");
            }else {
                JOptionPane.showMessageDialog(null, "Calificacion no creada");
                return null;
            }

        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                MysqlConfigDB.closeConnection();
            }catch(SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return gradesEntity;
    }


    @Override
    public List<GradesEntity> readAll() {
        List<GradesEntity> gradesEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM grades;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                gradeType Grade_type = gradeType.valueOf(resultSet.getString("grade_type"));
                GradesEntity gradeEntity = new GradesEntity(
                        resultSet.getInt("id"),
                        resultSet.getDouble("grade"),
                        Grade_type,
                        resultSet.getInt("registration_id")
                );
                gradesEntities.add(gradeEntity);
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            try{
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
                MysqlConfigDB.closeConnection();
            }catch (SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return gradesEntities;
    }

    @Override
    public void update(Integer id, GradesEntity gradesEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "UPDATE grades SET grade = ?, grade_type = ?, registration_id = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, gradesEntity.getGrade());
            preparedStatement.setString(2, gradesEntity.getGrade_type().name());
            preparedStatement.setInt(3, gradesEntity.getRegistration_id());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Cliente Actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no Actualizado");
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                MysqlConfigDB.closeConnection();
            }catch (SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
