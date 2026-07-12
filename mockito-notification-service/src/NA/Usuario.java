package NA;


public class Usuario {
    private final String email;
    private final String telefono;
    private final CanalPreferido canal;

    public Usuario(String email, String telefono, CanalPreferido canal) {
        this.email = email;
        this.telefono = telefono;
        this.canal = canal;
    }

    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public CanalPreferido getCanal() { return canal; }
}
