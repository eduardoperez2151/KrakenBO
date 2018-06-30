/*
 * package com.geocom.repositories;
 * 
 * import com.geocom.dtos.IngredientDTO; import com.geocom.models.Ingredient;
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import
 * org.springframework.test.annotation.DirtiesContext; import
 * org.springframework.test.context.ActiveProfiles; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import java.util.List; import java.util.Optional; import
 * java.util.stream.Collector; import java.util.stream.Collectors; import
 * java.util.stream.Stream;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * @ActiveProfiles("test")
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @DataJpaTest public class IngredientRepositoryTest {
 * 
 * @Autowired private TestEntityManager entityManager;
 * 
 * @Autowired private IngredientRepository ingredientRepository;
 * 
 * @Test public void testGetById() throws Exception {
 * 
 * final Ingredient ingredient = Ingredient.builder() .amount(3d)
 * .name("oranges") .build();
 * 
 * final Ingredient persistedIngredient =
 * this.entityManager.persist(ingredient); final Optional<Ingredient>
 * retrievedIngredient =
 * this.ingredientRepository.findById(persistedIngredient.getId());
 * 
 * assertThat(persistedIngredient).isEqualTo(retrievedIngredient.orElseThrow(()-
 * >new Exception("Error al persistir"))); }
 * 
 * 
 * 
 * @Test public void testGetAllIngredients() throws Exception{ final
 * List<IngredientDTO> allIngredients =
 * this.ingredientRepository.findAllIngredients();
 * assertThat(allIngredients).isNotNull();
 * assertThat(allIngredients).isNotEmpty();
 * assertThat(allIngredients.size()).isEqualTo(6);
 * 
 * final List<IngredientDTO> ingredientsFiltered = allIngredients.stream()
 * .filter(i -> i.getName().equals("Carne")) .collect(Collectors.toList());
 * 
 * assertThat(ingredientsFiltered).isNotNull();
 * assertThat(ingredientsFiltered).isNotEmpty();
 * assertThat(ingredientsFiltered.size()).isEqualTo(1);
 * assertThat(ingredientsFiltered.get(0).getAmount()).isEqualTo(2);
 * 
 * }
 * 
 * 
 * }
 */