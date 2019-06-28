package Logic;

import com.mpatric.mp3agic.*;

import javax.imageio.ImageIO;
import java.io.*;

public class Music implements Serializable {
    private String Album;
    private String Name;
    private String Artist;
    private String Path;
    private Mp3File mp3file;

    public String getAlbum() {
        return Album;
    }

    public String getName() {
        return Name;
    }

    public String getArtist() {
        return Artist;
    }

    public String getPath() {
        return Path;
    }

    public byte[] getArtWork() {
        return ArtWork;
    }

    private byte[] ArtWork;

    public Music(String path) {
        Path = path;
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
            this.Album = id3v1Tag.getAlbum();
            this.Artist = id3v1Tag.getArtist();
        }
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            if(id3v2Tag.getAlbumImage()!=null)
                ArtWork = id3v2Tag.getAlbumImage();
            else{
                ByteArrayOutputStream bos =new ByteArrayOutputStream();
                try {
                    ImageIO.write(ImageIO.read(new File("C:\\Users\\Sadegh\\Desktop\\J\\Jpotify\\assets\\image\\Default.Jpg")),"jpg",bos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
                ArtWork= bos.toByteArray();
            }
        }
        Name=new File(Path).getName();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
