import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distillery", required = false) Long distilleryId
    ){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByAgeGreaterThan(year), HttpStatus.OK);
        }

        if (age != null && distilleryId != null){
            return new ResponseEntity<>(whiskyRepository.findDistilleryByRegion(age, distilleryId), HttpStatus.OK);
        }

        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
