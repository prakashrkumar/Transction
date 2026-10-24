package prakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prakash.entity.TransferRecord;

public interface TransferRepository extends JpaRepository<TransferRecord,Long> {
}
