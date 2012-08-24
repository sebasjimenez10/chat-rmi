
/**
 *
 * @author Menes
 */
import java.rmi.Naming;

public class ServerBoard {

    public ServerBoard() {
    }

    public static void main(String args[]) {
        try {
            Board b = new Board();
            Naming.rebind("salaunica", b);
        } catch (Exception e) {
            System.out.println("Hubo un error registrando el objeto Board");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Server ready...");
    }
}