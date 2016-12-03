import java.util.ArrayList;
public class Room {

    ArrayList<String> roomCodes;

    public Room(ArrayList<String> roomCode){
        this.roomCodes = roomCode;
    }

    public Room(){}

    public String toString(){

        return " Room: " + roomCodes.toString();
    }
}
