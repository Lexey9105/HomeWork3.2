package ru.hogwarts.school3_2.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.hogwarts.school3_2.model.Faculty;
import ru.hogwarts.school3_2.model.Student;
import ru.hogwarts.school3_2.service.FacultyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.chrono.JapaneseEra.values;


@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map <Long , Faculty> storageFac;
    private Long size=0L;

public FacultyServiceImpl(){
    this.storageFac=new HashMap<>();
}
    @Override
    public Faculty createFaculty(Long id,String name,String color) {
        if(StringUtils.isAlpha(name)||StringUtils.isAlpha(color)||id==null||id==0){throw new RuntimeException("введен пустой запрос");}
        if(storageFac.containsKey(id)){throw new RuntimeException("Сотрудник уже добавлен");}
        Faculty faculty=new Faculty(id, name, color);
        Long idAdd= faculty.getId();
        storageFac.put(idAdd,faculty);
        size++;
    return faculty;
    }

    @Override
    public Faculty updateFaculty(Long id,String name,String color) {
        if(StringUtils.isAlpha(name)||StringUtils.isAlpha(color)||id==null||id==0){throw new RuntimeException("введен пустой запрос");}
        if(!storageFac.containsKey(id)){throw new RuntimeException("Сотрудник не найден");}

        storageFac.remove(id);
        Faculty faculty=new Faculty(id, name, color);
        Long idAdd= faculty.getId();
        storageFac.put(idAdd,faculty);
    return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        if(!storageFac.containsKey(id)){throw new RuntimeException("Сотрудник не найден");}
        if(id==null||id==0){throw new RuntimeException("введен пустой запрос");}
        storageFac.get(id);
        Faculty faculty=storageFac.get(id);
    return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        if(id==null||id==0){throw new RuntimeException("введен пустой запрос");}
        if(!storageFac.containsKey(id)){throw new RuntimeException("Сотрудник не найден");}
        storageFac.get(id);
        Faculty faculty=storageFac.get(id);
        storageFac.remove(id);
    size--;
        return faculty;
    }
    @Override
    public  Collection<Faculty> facFilter(String color){
        return storageFac.values().stream()
                .findAny().filter(e -> e.getColor().equals(color))
                .stream().collect(Collectors.toList());
    }
}
