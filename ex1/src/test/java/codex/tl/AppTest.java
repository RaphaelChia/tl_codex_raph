package codex.tl;

import static org.junit.jupiter.api.Assertions.*;

import codex.tl.entity.states.Available;
import codex.tl.entity.states.Occupied;
import codex.tl.entity.states.Repair;
import codex.tl.entity.states.Vacant;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Hotel hotel;

    @BeforeEach
    public void Setup(){
        hotel=new Hotel();
    }

    @Test
    public void HotelCreatedWithCorrectNumberRoom_normal(){
        assertEquals(20, hotel.getRooms().length);
    }


    @Test
    public void HotelRequestRoomCorrect_normal(){
        HotelRoom hotelroom = hotel.requestRoom();
        assertTrue(hotelroom.getCurrentState() instanceof Occupied);
    }

    @Test
    public void HotelRequestRoomCorrect_OverMaxNumRooms(){
        HotelRoom hotelroom=null;
        for(int i=0;i<21;i++){
            hotelroom = hotel.requestRoom();
        }
        assertNull(hotelroom);
    }

    @Test
    public void HotelCleanRoomCorrect_fulltest(){
        HotelRoom initialHotelRoom = hotel.requestRoom();

        //Cleaning while occupied
        assertTrue(hotel.cleanRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Occupied);

        //cleaning while sent for repair
        hotel.checkoutRoom(initialHotelRoom.getRoomName());
        hotel.markRoomForRepair(initialHotelRoom.getRoomName());
        assertTrue(hotel.cleanRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Repair);

        //Cleaning after repair and now vacant
        hotel.repairRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.cleanRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Available);

        //Cleaning while Available
        assertTrue(hotel.cleanRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Available);
    }

    @Test
    public void HotelRepairRoomCorrect_fulltest(){
        HotelRoom initialHotelRoom = hotel.requestRoom();

        //Repair while occupied
        assertTrue(hotel.repairRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Occupied);

        //Repair while vacant
        hotel.checkoutRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.repairRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Vacant);

        //Repair while repair
        hotel.markRoomForRepair(initialHotelRoom.getRoomName());
        assertTrue(hotel.repairRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Vacant);

        //Repair while Available
        hotel.cleanRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.repairRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Available);
    }

    @Test
    public void HotelCheckoutRoomCorrect_fulltest(){
        HotelRoom initialHotelRoom = hotel.requestRoom();

        //Checkout while occupied
        assertTrue(hotel.checkoutRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Vacant);

        //Checkout while vacant
//        hotel.checkoutRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.checkoutRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Vacant);

        //Checkout while repair
        hotel.markRoomForRepair(initialHotelRoom.getRoomName());
        assertTrue(hotel.checkoutRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Repair);

        //Checkout while Available
        hotel.repairRoom(initialHotelRoom.getRoomName());
        hotel.cleanRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.checkoutRoom(initialHotelRoom.getRoomName()).getCurrentState() instanceof Available);
    }

    @Test
    public void HotelOutOfServiceCorrect_fulltest(){
        HotelRoom initialHotelRoom = hotel.requestRoom();

        //OOS while occupied
        assertTrue(hotel.markRoomForRepair(initialHotelRoom.getRoomName()).getCurrentState() instanceof Occupied);

        //OOS while vacant
        hotel.checkoutRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.markRoomForRepair(initialHotelRoom.getRoomName()).getCurrentState() instanceof Repair);

        //OOS while repair
//        hotel.markRoomForRepair(initialHotelRoom.getRoomName());
        assertTrue(hotel.markRoomForRepair(initialHotelRoom.getRoomName()).getCurrentState() instanceof Repair);

        //OOS while Available
        hotel.repairRoom(initialHotelRoom.getRoomName());
        hotel.cleanRoom(initialHotelRoom.getRoomName());
        assertTrue(hotel.markRoomForRepair(initialHotelRoom.getRoomName()).getCurrentState() instanceof Available);
    }

    @AfterEach
    public void Teardown(){
        hotel = null;
    }
}
