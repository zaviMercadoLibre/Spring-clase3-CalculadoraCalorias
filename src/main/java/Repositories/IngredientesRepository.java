package Repositories;

import Entities.Ingredientes;
import Entities.IngredientesDto;

public interface IngredientesRepository {
    IngredientesDto findByName(String name);
}
