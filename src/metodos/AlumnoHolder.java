package metodos;

import alumno.alumno;

public class AlumnoHolder {

    private static alumno usuario = new alumno();

    public static void setAlumno(alumno alumno) {
        AlumnoHolder.usuario = alumno;
    }

    public static alumno getAlumno() {
        return usuario;
    }
}

