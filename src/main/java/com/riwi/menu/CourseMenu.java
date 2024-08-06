package com.riwi.menu;

import com.riwi.controllers.CourseController;

import com.riwi.entities.CoursesEntity;
import com.riwi.entities.StudentsEntity;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public class CourseMenu {

    private static CourseController courseController = new CourseController();

    public static void Menu(){
        while(true){

            //variables
            Integer id;
            String name;
            Integer number_student;
            CoursesEntity coursesEntity = null;
            List<CoursesEntity> coursesEntityList = new ArrayList<>();

            String optionStudent = JOptionPane.showInputDialog(null, "Ingresa una opcion:  \n\n1: Crear\n2: Actualizar\n3: Leer\n4: Salir\n");

            switch (optionStudent){
                case "4":
                    return;
                case "1":
                    name = JOptionPane.showInputDialog(null, "Ingresa el nombre de el curso:  ");
                    number_student = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante" ));
                    coursesEntity = new CoursesEntity(0, name, number_student);
                    courseController.create(coursesEntity);
                    break;
                case "2":
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del studiante que desea Actualizar"));
                    name = JOptionPane.showInputDialog(null, "Ingresa el nombre de el curso:  ");
                    number_student = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante" ));
                    coursesEntity = new CoursesEntity(0, name, number_student);
                    courseController.update(id, coursesEntity);
                    break;

                case "3":
                    coursesEntityList = courseController.readAll();
                    String lista = "";
                    for (CoursesEntity cs : coursesEntityList){
                        lista += cs.toString()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
            }
        }
    }
}
