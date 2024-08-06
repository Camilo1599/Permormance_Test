package com.riwi.models;

import com.riwi.entities.CoursesEntity;
import com.riwi.entities.RegistrationsEntity;
import com.riwi.persistences.configDB.MysqlConfigDB;
import com.riwi.persistences.imodels.ICourseModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModelImp implements ICourseModel {

    @Override
    public CoursesEntity create(CoursesEntity coursesEntity){
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();
        try{
            String sql = "INSERT INTO courses (course_id, student_id, number_student) VALUES (?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coursesEntity.getName());
            preparedStatement.setInt(1, coursesEntity.getNumber_student());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curso creado");
            }else {
                JOptionPane.showMessageDialog(null, "Curso no creada");
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
        return coursesEntity;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "DELETE FROM courses WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curso Eliminada");
            }else{
                JOptionPane.showMessageDialog(null, "Curso no Eliminada");
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
    public List<CoursesEntity> readAll() {
        List<CoursesEntity> coursesEntities = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM courses;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                CoursesEntity coursesEntity = new CoursesEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("number_student")


                );
                coursesEntities.add(coursesEntity);
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
        return coursesEntities;
    }

    @Override
    public void update(Integer id, CoursesEntity coursesEntity) {
        PreparedStatement preparedStatement = null;
        Connection connection = MysqlConfigDB.openConnection();

        try{
            String sql = "UPDATE courses SET course_id = ?, student_id = ? WHERE id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coursesEntity.getName());
            preparedStatement.setInt(2, coursesEntity.getNumber_student());
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Curso Actualizada");
            }else{
                JOptionPane.showMessageDialog(null, "Curso no Actualizada");
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
