package alumno;

import sql.Conectar;

import java.sql.*;

public class alumno {

    String dni;
    String nombre;
    String apellido;
    String correo;
    String contrasena;
    Boolean esalumno;
    Boolean esprofesor;
    Boolean esadmin;
    Boolean di;
    Boolean sge;
    Boolean hlc;
    Boolean pmm;
    Boolean psp;
    Boolean ad;
    Boolean emp;
    Boolean sexo;
    String biografia;
    int telefono;

    public alumno(){
    }

    //Setters
    public String getDni() {return dni;}
    public String getNombre() {return nombre;}

    public String getApellido(){return apellido;}

    public String getCorreo(){return correo;}

    public String getContrasena() {return contrasena;}
    public Boolean getEsalumno(){return esalumno;}

    public Boolean getEsprofesor() {return esprofesor;}

    public Boolean getEsadmin() {return esadmin;}

    public Boolean getDi() {return di;}

    public Boolean getSge() {return sge;}

    public Boolean getHlc() {return hlc;}

    public Boolean getPmm() {return pmm;}

    public Boolean getPsp() {return psp;}

    public Boolean getAd() {return ad;}

    public Boolean getEmp() {return emp;}

    public Boolean getSexo() {return sexo;}

    public String getBiografia() {return biografia;}
    public int getTelefono() {return  telefono;}

    //Getters
    public void setDni(String dni) {this.dni = dni;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public void setCorreo(String correo) {this.correo = correo;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public void setEsalumno(Boolean esalumno) {this.esalumno = esalumno;}

    public void setEsprofesor(Boolean esprofesor) {this.esprofesor = esprofesor;}

    public void setEsadmin(Boolean esadmin) {this.esadmin = esadmin;}

    public void setDi(Boolean di) {this.di = di;}

    public void setSge(Boolean sge) {this.sge = sge;}

    public void setHlc(Boolean hlc) {this.hlc = hlc;}

    public void setPmm(Boolean pmm) {this.pmm = pmm;}

    public void setPsp(Boolean psp) {this.psp = psp;}

    public void setAd(Boolean ad) {this.ad = ad;}

    public void setEmp(Boolean emp) {this.emp = emp;}

    public void setBiografia(String biografia) {this.biografia = biografia;}

    public void setSexo(Boolean sexo) {this.sexo = sexo;}
    public void setTelefono(int telefono) {this.telefono = telefono;}


}
