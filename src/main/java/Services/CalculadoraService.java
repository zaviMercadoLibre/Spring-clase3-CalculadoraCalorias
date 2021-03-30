package Services;

import Entities.Ingredientes;
import Entities.IngredientesDto;

import java.util.List;


public interface CalculadoraService {
    public Integer caloriasTotales(List<Ingredientes> ingredientes);
    public List<IngredientesDto> caloriasPorIng(List<Ingredientes> ingredientes);
    public IngredientesDto ingMayorCalorias(List<Ingredientes> ingredientes);
}
