
/**
 *
 * @author Menes
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class ChatUI {

    private ChatClient user;

    public ChatUI(ChatClient user) {
        this.user = user;
    }

    public static void main(String args[]) throws Exception {
        //User keyboard input
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        IBoard b = (IBoard) Naming.lookup("rmi://" + args[0] + "/salaunica");

        //Login
        System.out.println("Type your nickname");
        ChatUI chat = new ChatUI(new ChatClient(input.readLine()));
        b.login(chat.user.getAlias(), chat.user);
        System.out.println("User " + chat.user.getAlias() + " logged in!");

        //Send each line users enter
        while (true) {
            String s = input.readLine();
//            if (s.equalsIgnoreCase("/logout")) {
//                //Logout
//                b.logout(chat.user.getAlias());
//                input.close();
//                break;
//            }
            b.postMessage(s, chat.user);
        }
    }
}