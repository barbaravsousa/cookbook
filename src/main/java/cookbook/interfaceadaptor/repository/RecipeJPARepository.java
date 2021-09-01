package cookbook.interfaceadaptor.repository;

import cookbook.datamodel.RecipeJPA;
import org.springframework.data.repository.CrudRepository;

public interface RecipeJPARepository extends CrudRepository<RecipeJPA,String> {
}
