package recipe.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by maus__000 on 28.10.2015.
 */

@ContextConfiguration(classes = {RepositoryTestConfiguration.class})
public class RepositoryInterfaceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RepositoryInterface repo;

    @Before
    public void setUp() throws Exception
    {
        deleteFromTables("recipe");
        jdbcTemplate.update("insert into recipe (Name, Description) values ('Narf', 'foo')");
    }

    @Test
    public void testGetAllRecipes() throws Exception {

        List<Recipe> recipes = repo.getAllRecipes();
        assertEquals(1, recipes.size());
        Recipe recipe = recipes.get(0);
        assertEquals("Narf", recipe.getName());
        assertEquals("foo", recipe.getDescription());
    }

    @Test
    public void testGetById() throws Exception {
        List<Map<String,Object>> ids = jdbcTemplate.queryForList("select Id from recipe");
        Integer id = (Integer)ids.get(0).get("Id");

        Recipe recipe = repo.getById(id);
        assertEquals("Narf", recipe.getName());
        assertEquals("foo", recipe.getDescription());
    }
}