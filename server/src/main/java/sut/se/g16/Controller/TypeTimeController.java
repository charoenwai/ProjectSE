package sut.se.g16.Controller;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import sut.se.g16.Entity.TypeTimeEntity;
import sut.se.g16.Repository.TypeTimeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TypeTimeController{
    private TypeTimeRepository typeTimeRepository;
    public TypeTimeController(TypeTimeRepository typeTimeRepository){
        this.typeTimeRepository = typeTimeRepository;
    }
    @GetMapping ("/typetime/{name}")
    public TypeTimeEntity addTypeTime(@PathVariable String name){
        TypeTimeEntity typeTime = new TypeTimeEntity();
        typeTime.setTypeTimeName(name);
        return typeTimeRepository.save(typeTime);
    }

    @GetMapping("/typetimes")
    public Collection<TypeTimeEntity> typetime() {
        return typeTimeRepository.findAll().stream().collect(Collectors.toList());
    }
}