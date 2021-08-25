package cookbook.interfaceadaptor.repository;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.datamodel.RecipeJPARepository;
import cookbook.datamodel.assembler.RecipeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository implements IRecipeRepository {

    @Autowired
    RecipeJPARepository repository;
    @Autowired
    RecipeAssembler assembler;

}
