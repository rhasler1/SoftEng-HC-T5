import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class TestHealthClubSystem {

    //@RepeatedTest(100)
    @Test
    @DisplayName("Test generate membership id")
    public void testGenerateID() {
        HealthClubSystem.setMembers(); // set state of hashmap
        HashMap<String, Member> members = HealthClubSystem.getMembers(); // get state
        String membershipID = HealthClubSystem.generateMembershipID(); // generate member id
        assertNotNull(membershipID);
        assertFalse(membershipID.isEmpty());
        assertNotNull(members);
        assertFalse(members.isEmpty());
        assertEquals(12, membershipID.length());
        assertFalse(members.containsKey(membershipID));
    }

    @Test
    @DisplayName("Test delete member")
    public void testDeleteAccount() {
        HealthClubSystem.setMembers(); // set state of hashmap
        HashMap<String, Member> members = HealthClubSystem.getMembers(); // get state
        assertNotNull(members);
        assertFalse(members.isEmpty());
        assertTrue(members.containsKey("222222222222"));
        HealthClubSystem.removeMember("222222222222");
        assertFalse(members.containsKey("222222222222"));
    }

    @Test
    @DisplayName("Test create member")
    public void createAccount() {
        HealthClubSystem.setMembers(); // set state of hashmap
        HashMap<String, Member> members = HealthClubSystem.getMembers(); // get state
        String id = HealthClubSystem.generateMembershipID();
        int initialSize = members.size();
        HealthClubSystem.createMember(id, "Michael", "White", "9998887777",
                "mwhite@gmail.com", "Student", "2023-02-05" ,"12", "Good");
        assertEquals(members.size(), initialSize+1);
        assertTrue(members.containsKey(id));
    }
}
