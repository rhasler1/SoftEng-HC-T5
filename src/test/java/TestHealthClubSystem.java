import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestHealthClubSystem {

    //@RepeatedTest(100)
    @Test
    @DisplayName("Test generate membership id")
    public void testGenerateID() {
        String membershipID = HealthClubSystem.generateMembershipID();
        assertNotNull(membershipID);
        assertFalse(membershipID.isEmpty());
        assertEquals(12, membershipID.length());
        assertFalse(FileOps.getMembers().containsKey(membershipID));
    }

    @Test
    @DisplayName("Test delete member account")
    public void testDeleteAccount() {
        HealthClubSystem.members = FileOps.getMembers();
        assertNotNull(HealthClubSystem.members);
        assertFalse(HealthClubSystem.members.isEmpty());
        HealthClubSystem.removeMember("222222222222");
        assertFalse(HealthClubSystem.members.containsKey("222222222222"));
    }
}
