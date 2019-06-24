package Logic;

import com.mpatric.mp3agic.*;

import java.io.IOException;

public class Music {
    String Album;
    String Name;
    String Artist;
    private String Path;
    Mp3File mp3file;
    public byte[] ArtWork;              //memetype shayad bayad ezafe she

    public Music(String path,String name) {
        Path = path;
        Name=name;
        Mp3File mp3file = null;
        try {
            mp3file = new Mp3File(Path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            this.Album=id3v1Tag.getAlbum();
            this.Artist=id3v1Tag.getArtist();
        }
        if(mp3file.hasId3v2Tag()){
            ID3v2 id3v2Tag= mp3file.getId3v2Tag();
            ArtWork=id3v2Tag.getAlbumImage();
        }
    }
}