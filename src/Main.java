
import java.awt.Desktop;
import java.net.URI;
public class Main {
    public static UserInput userInput = new UserInput();
    public static Playlist playlist= new Playlist(userInput, Desktop.getDesktop());
        public static void main(String[] args) throws Exception {
            // userInput.printSearchQuery(userInput.getSearch(userInput.getSearchQuery()));
            // Desktop.getDesktop().browse(new URI(userInput.getYoutubeVideoViaURL(userInput.getURLKey())));
            // Desktop.getDesktop().browse(new URI(userInput.getSearch(userInput.getSearchQuery())));
            playlist.playPlaylist();

        
        
    }
}
