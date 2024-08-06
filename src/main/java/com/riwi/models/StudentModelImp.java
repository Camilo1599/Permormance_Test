package com.riwi.models;

import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.configDB.MysqlConfigDB;
import com.riwi.persistences.imodels.IStudentModel;
import com.riwi.persistences.util.enums.studentStatus;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModelImp implements IStudentModel {

    @Override
    public StudentsEntity create(StudentsEntity studentEntity){
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();
        try{
            String sql = "INSERT INTO students (name, lastname, email, document, status) VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentEntity.getName());
            preparedStatement.setString(2, studentEntity.getLastname());
            preparedStatement.setString(3, studentEntity.getEmail());
            preparedStatement.setString(4, studentEntity.getDocument());
            preparedStatement.setString(5, studentEntity.getStatus().name());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Estudiante creado");
            }else {
                JOptionPane.showMessageDialog(null, "Estudiante no creado");
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
        return studentEntity;
    }


    @Override
    public List<StudentsEntity> readAll() {
        List<StudentsEntity> studentsEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM students;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                studentStatus Status = studentStatus.valueOf(resultSet.getString("status"));
                StudentsEntity studentEntity = new StudentsEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("document"),
                        Status
                );
                studentsEntities.add(studentEntity);
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
        return studentsEntities;
    }

    @Override
    public void update(Integer id, StudentsEntity studentsEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "UPDATE clientes SET name = ?, lastname = ?, email = ?, document = ?, status = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentsEntity.getName());
            preparedStatement.setString(2, studentsEntity.getLastname());
            preparedStatement.setString(3, studentsEntity.getEmail());
            preparedStatement.setString(4, studentsEntity.getDocument());
            preparedStatement.setString(5, studentsEntity.getStatus().name());
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
