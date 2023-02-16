package logica;

import persistence.PersistenceController;
import persistence.Persona;

import java.util.List;

public class LogicController {

    PersistenceController persistence = new PersistenceController();

    public void crearPersona(){
        Persona objPersona = new Persona(0,"Pepito","Perez","pepito@hotmail.com");
        persistence.crearPersona(objPersona);
    }

    public void buscarPersonas(){
        List<Persona> listaPersonas = persistence.buscarPersonas();

        for (Persona persona:listaPersonas) {
            System.out.println(persona);
        }
    }

    public void eliminarPersona(){
        int id = 7;
        persistence.eliminarPersona(id);
    }

    public void actualizarPersona(){
        persistence.actualizarPersona(1,"Juan Felipe","Herman Lasso");
    }

}
