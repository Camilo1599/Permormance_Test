package com.riwi;


import com.riwi.menu.CourseMenu;
import com.riwi.menu.StudentMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true){
            String decision = JOptionPane.showInputDialog(null, "Ingresa una opcion: \n\n1. Studiantes\n2:. Cursos\n3. Salir");
            switch (decision){
                case ("3")->{
                    return;

                }
                case ("1")->{
                    StudentMenu.Menu();
                }
                case ("2")->{
                    CourseMenu.Menu();
                }

            }
        }
    }
}