public class Main {
    public static void main(String[] args) {
        Escribir_clientes ec = new Escribir_clientes();
        LeerCLientes lc = new LeerCLientes();
        ec.crear();
        lc.leer();
    }
}