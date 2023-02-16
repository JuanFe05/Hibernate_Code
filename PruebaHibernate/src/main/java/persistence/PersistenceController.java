package persistence;

import dao.PersonaController;

import java.util.List;

public class PersistenceController {

    PersonaController personaJPA = new PersonaController();

    public void crearPersona(Persona persona){
        personaJPA.crearPersona(persona);
    }

    public List<Persona> buscarPersonas(){
        return personaJPA.listarPersonas();
    }

    public void eliminarPersona(int id){
        personaJPA.eliminarPersona(id);
    }

    public void actualizarPersona(int id, String nombres, String apellidos){
        personaJPA.actualizarPersona(id, nombres, apellidos);
    }

}
