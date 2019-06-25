package Logic;

import javazoom.jl.player.Player;

import java.io.*;
import java.util.LinkedList;

public class IOClass {
        public void saveSongs(LinkedList<Music> songs){
            ObjectOutputStream outputStream= null;
            try {
                outputStream = new ObjectOutputStream(new FileOutputStream("./saved/Songs.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Music m:songs){
                try {
                    outputStream.writeObject(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void savePlaylists(LinkedList<PlayList> playLists){
            ObjectOutputStream outputStream=null;
            try {
                outputStream=new ObjectOutputStream(new FileOutputStream("./saved/Playlists.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(PlayList p:playLists){
                try {
                    outputStream.writeObject(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void saveAlbums(LinkedList<Albums> albums){
            ObjectOutputStream outputStream=null;
            try {
                outputStream=new ObjectOutputStream(new FileOutputStream("./saved/Albums.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Albums a:albums){
                try {
                    outputStream.writeObject(a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public LinkedList<Music> LoadSongs(){
            ObjectInputStream objectInputStream= null;
            try {
                objectInputStream = new ObjectInputStream((new FileInputStream("./saved/Songs.bin")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            LinkedList<Music> songs=new LinkedList<Music>();
            while(true){

                try {
                    songs.add((Music) objectInputStream.readObject());
                } catch (EOFException ex){
                    try {
                        objectInputStream.close();
                        return songs;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        public LinkedList<Albums> LoadAlbums(){
            ObjectInputStream objectInputStream=null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream("./saved/Albums.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            LinkedList<Albums> albums=new LinkedList<Albums>();
            while (true){
                try {
                    albums.add((Albums) objectInputStream.readObject());
                } catch (EOFException ex){
                    try {
                        objectInputStream.close();
                        return albums;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        public LinkedList<PlayList> LoadPlaylists(){
            ObjectInputStream objectInputStream=null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream("./saved/Playlists.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            LinkedList<PlayList> playLists= new LinkedList<PlayList>();
            while (true){
                try {
                    playLists.add((PlayList) objectInputStream.readObject());
                } catch (EOFException ex){
                    try {
                        objectInputStream.close();
                        return playLists;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
}
