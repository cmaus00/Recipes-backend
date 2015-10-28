package recipe.model;

/**
 * Created by maus__000 on 26.10.2015.
 */
public class Recipe
{
    private final Integer id;

    private String name;

    private String description;

    public Recipe(Integer id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
