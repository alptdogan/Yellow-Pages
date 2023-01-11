package comalpdogan.YellowPages.repository;

import comalpdogan.YellowPages.entity.Firm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmRepository extends CrudRepository<Firm, Integer> {



}
