package algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountsMergeTest {

    @Test
    void accountsMerge() {
        AccountsMerge cl = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));


        assertEquals(
                Arrays.asList(
                        Arrays.asList("John", "johnnybravo@mail.com"),
                        Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")
                ),
                cl.accountsMerge(accounts)
        );
    }
}