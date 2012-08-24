
/**
 *
 * @author Menes
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient extends UnicastRemoteObject implements IChatClient {

    private String alias;

    public ChatClient(String alias) throws RemoteException {
        this.alias = alias;
    }

    @Override
    public String getAlias() throws RemoteException {
        return alias;
    }

    @Override
    public void viewBoardMsg(String msg) throws RemoteException {
        System.out.println(msg);
    }
}