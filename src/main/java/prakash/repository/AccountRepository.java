package prakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prakash.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
