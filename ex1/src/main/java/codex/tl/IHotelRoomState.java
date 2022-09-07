package codex.tl;

public interface IHotelRoomState {
    void checkin();
    void checkout();
    void clean();
    void outOfService();
    void repaired();
}
