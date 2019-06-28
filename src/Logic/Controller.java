package Logic;

import GUI.Main;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Controller {
    private LinkedList<Music> songs;
    private LinkedList<Albums> albums;
    private LinkedList<PlayList> playLists;
    private Music Nowplaying = null;
    private ListIterator<Music> Musicque=null;

    public void setSongs(LinkedList<Music> songs) {
        this.songs = songs;
    }

    public void setAlbums(LinkedList<Albums> albums) {
        this.albums = albums;
    }

    public void setPlayLists(LinkedList<PlayList> playLists) {
        this.playLists = playLists;
    }

    public ListIterator<Music> getMusicque() {
        return Musicque;
    }

    public void setMusicque(ListIterator<Music> musicque) {
        Musicque = musicque;
    }

    public Music getNowplaying() {
        return Nowplaying;
    }

    public void setNowplaying(Music nowplaying) {
        Nowplaying = nowplaying;
    }

    public LinkedList<PlayList> getPlayLists() {
        return playLists;
    }

    public Controller() {
        IOClass ioClass=new IOClass();
        if(ioClass.LoadAlbums()!=null) {
            this.songs = ioClass.LoadSongs();
            this.albums = ioClass.LoadAlbums();
            this.playLists = ioClass.LoadPlaylists();
        }
        else {
            this.songs=new LinkedList<Music>();
            this.albums=new LinkedList<Albums>();
            this.playLists= new LinkedList<PlayList>();
        }
    }
    public void addToLibrary(Music m){
        songs.add(m);
        String albumname=m.getAlbum();
        int flag=0;
        for(Albums a:albums){
            if(a.getName()==albumname){
                a.add(m);
                flag=1;
            }
        }
        if(flag==0){
            Albums a=new Albums(albumname);
            a.add(m);
            albums.add(a);
        }
    }
    public void NewPlaylist(PlayList playList){
        playLists.add(playList);
    }
    public LinkedList<Music> getSongs(){
        return songs;
    }
    public LinkedList<Albums> getAlbums(){
        return albums;
    }
}
