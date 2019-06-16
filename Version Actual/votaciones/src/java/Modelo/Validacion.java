//  Validacion.java
//  EIF209 - Programacion 4 -Proeycto #2
//  Abril 2019
//
//  Autores:
//  Djenane Hernandez Rodriguez
//  Diego Monterrey Benavides
//  Carlos Obando Avendaña
package Modelo;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validacion implements Serializable {

    public static void validacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession se = request.getSession(true);
        Usuario e = (Usuario) se.getAttribute("usuario");
        if (e == null) {
            request.getRequestDispatcher("loginError.jsp").forward(request, response);
        } 
    }
}
