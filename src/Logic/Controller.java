package Logic;

import java.util.LinkedList;

public class Controller {
    private LinkedList<Music> songs;
    private LinkedList<Albums> albums;
    private LinkedList<PlayList> playLists;
    private Music Nowplaying=null;

    public Music getNowplaying() {
        return Nowplaying;
    }

    public void setNowplaying(Music nowplaying) {
        Nowplaying = nowplaying;
    }

    public Controller() {
        IOClass ioClass=new IOClass();
        this.songs = ioClass.LoadSongs();
        this.albums = ioClass.LoadAlbums();
        this.playLists = ioClass.LoadPlaylists();
    }
    public void addToLibrary(String Path){
        Music m=new Music(Path);
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
    public void NewPlaylist(String Path,String name,boolean isdelete,boolean canchange){
        PlayList playList=new PlayList(name,isdelete,canchange,Path);
        playLists.add(playList);
    }
    public void PlaySongs(){
    }
    public void PlayAlbum(){

    }
    public void PlayPlaylist(){

    }
    public void getSongs(){          // sort bayad she

    }
    public void getAlbums(){      // sort bayad she

    }
}
