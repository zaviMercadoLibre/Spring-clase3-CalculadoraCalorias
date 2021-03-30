package Services;

import Entities.Ingredientes;
import Entities.IngredientesDto;
import Entities.PlatoComida;
import Entities.ResponseDto;
import Repositories.IngredientesRepository;
import Repositories.IngredientesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService{

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Override
    public Integer caloriasTotales(List<Ingredientes> ingredientes) {
        int total = 0;

        for (Ingredientes i: ingredientes) {

            int calorias = ingredientesRepository.findByName(i.getNombre())!= null ? ingredientesRepository.findByName(i.getNombre()).getCalories() : 0;

            total = total + i.getPeso() * calorias;
        }
        return total;
    }

    @Override
    public List<IngredientesDto> caloriasPorIng(List<Ingredientes> ingredientes) {
        List<IngredientesDto> result = new ArrayList<IngredientesDto>();
        for (Ingredientes i:ingredientes) {
            IngredientesDto list = null;
            list = ingredientesRepository.findByName(i.getNombre());
            result.add(list);
        }
        return result;
    }

    @Override
    public IngredientesDto ingMayorCalorias(List<Ingredientes> ingredientes) {
        int maxCalories = 0;
        IngredientesDto ingMayorCalorias = null;

        for (Ingredientes i: ingredientes) {
            int compare = ingredientesRepository.findByName(i.getNombre()).getCalories();

            if(maxCalories == 0){
                maxCalories= compare;
            }
            if(maxCalories < compare){
                maxCalories = compare;
                ingMayorCalorias = ingredientesRepository.findByName(i.getNombre());
            }
        }

        return ingMayorCalorias;
    }

    public ResponseDto getResponse(PlatoComida plato){

        ResponseDto res = new ResponseDto();
        res.setCaloriasTotales(caloriasTotales(plato.getIngredientes()));
        res.setCaloriasInd(caloriasPorIng(plato.getIngredientes()));
        res.setIngMayorCalorias(ingMayorCalorias(plato.getIngredientes()));

        return res;
    }
}
