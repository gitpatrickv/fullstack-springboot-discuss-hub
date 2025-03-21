package com.fullstack.discuss_hub.common.util.mapper;


import com.fullstack.discuss_hub.common.dto.AuditEntity;
import com.fullstack.discuss_hub.common.dto.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
@AllArgsConstructor
public class ModelToEntityMapper <M extends Model, E extends AuditEntity>{

    private Class<E> destEntityClass;

    public E map(M model){
        ModelMapper mapper = new ModelMapper();
        return (E)mapper.map(model, this.destEntityClass);
    }

}

