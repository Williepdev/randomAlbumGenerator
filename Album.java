import java.util.*;
import java.util.ArrayList;

public class Album {

  private String name;
  private String artist;
  private String genre;
  private String releaseDate;
  private int albumRank;
  private int numberOfSongs;
  private ArrayList<Song> trackList;

  public Album(String name, String artist, String genre, int albumRank, 
  int numberOfSongs, ArrayList<Song> trackList, String releaseDate)
  {
    this.name = name;
    this.artist = artist;
    this.genre = genre;
    this.releaseDate = releaseDate;
    this.numberOfSongs = numberOfSongs;
    this.trackList = trackList;
    this.albumRank = albumRank;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getRank()
  {
    return albumRank;
  }
  
  public String getArtist()
  {
    return artist;
  }
  
  public String getGenre()
  {
    return genre;
  }
  
  public int getNumberOfSongs()
  {
    return numberOfSongs;
  }
  
  public ArrayList<Song> getTrackList()
  {
    return trackList;
  }
  
  public int getRunTime()
  {
    double total = 0;
    
    for(Song i : trackList)
    {
      total += i.getDuration();
    }
    
    return (int)(total);
  }
  
  public void printTrackList()
  {
    for(Song i : trackList)
    {
      System.out.println(i);
    }
  }
}