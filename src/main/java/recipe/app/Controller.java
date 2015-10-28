package recipe.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipe.model.Recipe;
import recipe.model.RepositoryInterface;

import java.util.List;

/**
 * Created by maus__000 on 26.10.2015.
 */
@CrossOrigin
@RestController
public class Controller
{
    private RepositoryInterface repository;

    public Controller(RepositoryInterface repo)
    {
        repository = repo;
    }

    @RequestMapping("/recipes")
    public List<Recipe> getAllRecipes()
    {
        return repository.getAllRecipes();
    }

    @RequestMapping("/recipes/{id}")
    public Recipe getById(@PathVariable Integer id)
    {
        return repository.getById(id);
    }
}
