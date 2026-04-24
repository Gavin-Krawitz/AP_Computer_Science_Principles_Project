
import java.awt.Desktop;
import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.WebSocket.Listener;
import java.util.Arrays;
public class Playlist {
    public String[] playlist={};
    public UserInput input;
    public String decision;
    public String video;
    public Desktop desktop;
    SystemEventListener listener = new SystemEventListener() {
        
    };
    public Playlist(UserInput input, Desktop desktop){
        this.input=input;
        this.desktop=desktop;

    }

    public void addToPlaylist(int amount) throws IOException, URISyntaxException{
        for(int i=0; i<amount;i++){
        System.out.println("Would you like to Search for a video or pull up a video URL");
        System.out.println("Type 'Search Query' to do a search or type 'URL' to paste in the video URL");
        decision=input.getInput();
        while (!decision.matches("URL")&&!decision.matches("Search Query")) {
            System.out.println("Please type 'Search Query' to do a search or type 'URL' to paste in the video URL");
            decision=input.getInput();  
            // System.out.println(decision); 
        }
        if (decision.matches("URL")){
            video=input.getYoutubeVideoViaURL(input.getURLKey());
        }else{
            video=input.getSearch(input.getSearchQuery());
            
        }
      
        playlist=Arrays.copyOf(playlist, playlist.length+1);
        playlist[playlist.length-1]=video;
        System.out.print(playlist[playlist.length-1]);
    }
        
    }
    public void playPlaylist() throws IOException, URISyntaxException{
        System.out.println("How many videos would you like to add to the playlist");
        int amount=input.getIntInput();
        this.addToPlaylist(amount);
        for(int i=0; i< playlist.length;i++){
            System.out.println(playlist[i]);
            desktop.browse(new URI(playlist[i]));
            
            
            
        }
    }
    
}
