package Controllers;

import Entities.PlatoComida;
import Entities.ResponseDto;
import Services.CalculadoraService;
import Services.CalculadoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @Autowired
    private CalculadoraServiceImpl calculadora ;

    @PostMapping("/calcular")
    public ResponseDto calcularCalorias(@RequestBody PlatoComida plato){

     return calculadora.getResponse(plato);
    }
}
