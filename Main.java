import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      ArrayList<Song> darksideTracks = new ArrayList<Song>();
      
      Song x = new Song("Pink Floyd", "Speak to Me", 1.30);
      Song y = new Song("Pink Floyd", "Breathe", 2.43);
      Song z = new Song("Pink Floyd", "Time", 6.53);
      darksideTracks.add(x);
      darksideTracks.add(y);
      darksideTracks.add(z);
      Album darkSideOfTheMoon = new Album("Dark Side Of The Moon", "Pink Floyd", "classic rock", 55, 3, darksideTracks, "10/23/23");
      
      ArrayList<album> albums = albumRead();
      printAlbums(albums);
      
  }
  
  
  public static Album generateAlbum(ArrayList<Album> albumList)
  {
    int span = albumList.size();
    
    int num = (int)(Math.random() * span) + 1;
    
    return albumList.get(num);
  }
  
  public static void printAlbums(ArrayList<Album> albums)
  {
    for(album a : albums)
    {
      System.out.println("Album: " + a.getName());
      System.out.println("Artist: " + a.getArtist());
      System.out.println("Songs:");
      for(song s : a.getTrackList())
      {
        System.out.println("- " + s.getName());
      }
      System.out.println();
    }
  }
  
  public static ArrayList<Album> albumRead()
  {
    ArrayList<album> albums = new ArrayList<album>();
    try {
      File file = new File("albums.txt");
      Scanner in = new Scanner(file);
      
      String name = "", artist = "", genre = "", releaseDate =  "";
      int rank = 0;
      ArrayList<Song> trackList = new ArrayList<Song>();
      
      while(in.hasNextLine()){
        String line = in.nextLine().trim();
        
        if(line.isEmpty())
        {
          Album a = new Album(name, artist, genre, rank, trackList.size(), trackList, releaseDate);
          albums.add(a);
          trackList = new ArrayList<Song>();//clear tracklist for next
          continue;
        }
      }
      
      String[] parts = line.split("\\|");
      if(parts[0].equals("ALBUM"))
      {
        name = parts[1];
        artist = parts[2];
        genre = parts[3];
        rank = Integer.parseInt(parts[4]);
        releaseDate = parts[5];
      }
      else if(parts[0].equals("SONG"))
      {
        String songName = parts[1];
        double duration = Double.parseDouble(parts[2]);
        song s = new song(artist, songName,duration);
        trackList.add(s);
      }
      }
      
      if(!trackList.isEmpty())
      {
        album a = new album(name, artist, genre, rank, trackList.size(), trackList, releaseDate);
        albums.add(a);
      }
      
      in.close();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    
  
    return albums;
  }
  
}