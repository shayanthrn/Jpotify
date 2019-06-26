package Logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Albums implements Serializable {
    private String name;
    private ArrayList<Music> songs;

    public Albums(String name) {
        this.name = name;
        songs=new ArrayList<Music>();
    }
    public void add(Music m){
        songs.add(m);
    }
    public void remove(Music m){
        songs.remove(m);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Music> getSongs() {
        return songs;
    }
    public byte[] getImage(){
        if(!songs.isEmpty()){
            return songs.get(1).getArtWork();
        }
        else
            return null;
    }
}
