
/**
 *
 * @author Menes
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Board extends UnicastRemoteObject implements IBoard {

    HashMap cc = new HashMap();

    public Board() throws RemoteException {
    }

    @Override
    public void postMessage(String msg, IChatClient userWhoSent) throws RemoteException {
        Collection usersOnline = cc.values();
        Iterator iter = usersOnline.iterator();
        int count = 0;
        while (iter.hasNext()) {
            IChatClient icc = (IChatClient) iter.next();
            if (!userWhoSent.equals(cc.get(icc.getAlias()))) {
                icc.viewBoardMsg(userWhoSent.getAlias() + " dijo: " + msg);
            }
            count++;
        }
    }

    @Override
    public void login(String alias, IChatClient c) throws RemoteException {
        cc.put(alias, c);
        System.out.println("Added: " + alias + ", Users online: " + cc.size());
    }

    @Override
    public void logout(String alias) throws RemoteException {
        cc.remove(alias);
    }
}