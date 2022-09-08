package codex.tl.entity.states;


/**
 * The methods in this interface are the actions that can be carried out as a hotel room.
 * If more states have to be introduced, just create a new state class and implement IHotelRoomState.
 * If more actions have to be introduced, just add the methods inside here, and change all
 * classes that implements IHotelRoomState.
 */
public interface IHotelRoomState {
    void checkin();
    void checkout();
    void clean();
    void outOfService();
    void repaired();
}
