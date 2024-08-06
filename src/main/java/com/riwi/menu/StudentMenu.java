package com.riwi.menu;

import com.riwi.controllers.StudentController;
import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.util.enums.studentStatus;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentMenu {
    private static StudentController studentController = new StudentController();

    public static void Menu(){
        while(true){

            //variables
            Integer id;
            String name;
            String lastname;
            String email;
            String document;
            studentStatus status;
            StudentsEntity studentsEntity = null;
            List<StudentsEntity> studentsEntityList = new ArrayList<>();

            String optionStudent = JOptionPane.showInputDialog(null, "Ingresa una opcion:  \n\n1: Crear\n2: Actualizar\n3: Leer\n4: Salir\n");

            switch (optionStudent){
                case "4":
                    return;
                case "1":
                    name = JOptionPane.showInputDialog(null, "Ingresa el nombre de el estudiante:  ");
                    lastname = JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante" );
                    email = JOptionPane.showInputDialog(null, "Ingresa el email del estudiante");
                    document = JOptionPane.showInputDialog(null, "Ingrese el numero del documento de identidad");
                    status = (studentStatus) JOptionPane.showInputDialog(
                            null,
                            "Choose a Status:",
                            "",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            studentStatus.values(),
                            studentStatus.values()
                    );
                    studentsEntity = new StudentsEntity(0, name, lastname, email, document, status);
                    studentController.create(studentsEntity);
                    break;
                case "2":
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del studiante que desea Actualizar"));
                    name = JOptionPane.showInputDialog(null, "Ingresa el nombre de el estudiante:  ");
                    lastname = JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante" );
                    email = JOptionPane.showInputDialog(null, "Ingresa el email del estudiante");
                    document = JOptionPane.showInputDialog(null, "Ingrese el numero del documento de identidad");
                    status = (studentStatus) JOptionPane.showInputDialog(
                            null,
                            "Choose a Status:",
                            "",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            studentStatus.values(),
                            studentStatus.values()
                    );
                    studentsEntity = new StudentsEntity(0, name, lastname, email, document, status);
                    studentController.update(id, studentsEntity);
                    break;

                case "3":
                    studentsEntityList = studentController.readAll();
                    String lista = "";
                    for (StudentsEntity cs : studentsEntityList){
                        lista += cs.toString()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
            }
        }
    }
}
