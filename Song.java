import java.util.*;
import java.util.ArrayList;

public class Song{
  
  private String key;
  private int tempo;
  private String name;
  private double duration/*as minutes.seconds*/;
  private String artist;
  //track number is assumed when putting songs into album arraylist
  
  public Song(String artist, String name, String key, int tempo, double duration)
  {
    this.artist = artist;
    this.name = name;
    this.duration = duration;
    this.key = key;
    this.tempo = tempo;
  }
  
  public Song(String artist, String name, double duration)
  {
    this.artist = artist;
    this.name = name;
    this.duration = duration;
    this.key = "";// no key specified
    this.tempo = 0;// no tempo specified
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getArtist()
  {
    return artist;
  }
  
  public double getDuration()
  {
    return duration;
  }
  
  public int getTempo()
  {
    return tempo;
  }
  
  public String getKey()
  {
    return key;
  }
}