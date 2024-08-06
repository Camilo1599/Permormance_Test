package com.riwi.models;

import com.riwi.entities.RegistrationsEntity;
import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.configDB.MysqlConfigDB;
import com.riwi.persistences.imodels.IRegistrationModel;
import com.riwi.persistences.imodels.IStudentModel;
import com.riwi.persistences.util.enums.studentStatus;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationModelImp implements IRegistrationModel {

    @Override
    public RegistrationsEntity create(RegistrationsEntity registrationEntity){
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();
        try{
            String sql = "INSERT INTO registrations (course_id, student_id) VALUES (?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationEntity.getCourse_id());
            preparedStatement.setInt(2, registrationEntity.getStudent_id());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscripcion creado");
            }else {
                JOptionPane.showMessageDialog(null, "Inscripcion no creada");
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
        return registrationEntity;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "DELETE FROM registrations WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscripcion Eliminada");
            }else{
                JOptionPane.showMessageDialog(null, "Inscripcion no Eliminada");
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

    @Override
    public List<RegistrationsEntity> readAll() {
        List<RegistrationsEntity> registrationsEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM registrations;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                RegistrationsEntity registrationEntity = new RegistrationsEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("course_id"),
                        resultSet.getInt("student_id")


                );
                registrationsEntities.add(registrationEntity);
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
        return registrationsEntities;
    }

    @Override
    public void update(Integer id, RegistrationsEntity registrationsEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "UPDATE registrations SET course_id = ?, student_id = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationsEntity.getCourse_id());
            preparedStatement.setInt(2, registrationsEntity.getStudent_id());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Inscripcion Actualizada");
            }else{
                JOptionPane.showMessageDialog(null, "Inscripcion no Actualizada");
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

