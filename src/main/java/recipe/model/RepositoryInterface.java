package recipe.model;

import recipe.model.Recipe;

import java.util.List;

/**
 * Created by maus__000 on 26.10.2015.
 */
public interface RepositoryInterface
{
    public List<Recipe> getAllRecipes();

    public Recipe getById(Integer id);
}
