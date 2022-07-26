package Proiectmicroservices.demo.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Find an account with the specified account number.
     *
     * @return The account if found, null otherwise.
     */
    public Account findByNumber(String accountNumber);

    /**
     * Find accounts whose owner name contains the specified string
     *
     * @param partialName Any alphabetic string.
     * @return The list of matching accounts - always non-null, but may be
     * empty.
     */
    public List<Account> findByOwnerContainingIgnoreCase(String partialName);

    /**
     * Fetch the number of accounts known to the system.
     *
     * @return The number of accounts.
     */
    @Query("SELECT count(*) from Account")
    public int countAccounts();
}
