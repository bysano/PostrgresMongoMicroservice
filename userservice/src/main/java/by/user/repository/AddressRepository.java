package by.user.repository;

import by.user.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * Created by alka0317 on 4/28/2017.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
