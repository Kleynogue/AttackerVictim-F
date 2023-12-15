package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Movimiento;
import com.ucab.cmcapp.logic.dtos.MovimientoDto;
import com.ucab.cmcapp.logic.dtos.TelefonoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class MovimientoMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( MovimientoMapper.class );

    public static Movimiento mapDtoToEntity(MovimientoDto dto) throws ParseException {
        Movimiento entity = EntityFactory.createMovimiento();

        _logger.debug( "Get in MovimientoMapper.mapDtoToEntity: dto {}", dto );

        entity.setMoviX(dto.getX());
        entity.setMoviY(dto.getY());
        entity.setMoviZ(dto.getZ());
        entity.setMoviFecha(BaseMapper.parseStringToDate(dto.getDate()));

        if(Objects.nonNull(dto.getTelefono())) {
            entity.setMoviFKTelefono(TelefonoMapper.mapDtoToEntity(dto.getTelefono()));
        }

        _logger.debug( "Leaving MovimientoMapper.mapDtoToEntity: entity {}", entity );

        return entity;
    }

    public static MovimientoDto mapEntityToDto(Movimiento entity){
        MovimientoDto dto = new MovimientoDto();

        _logger.debug( "Get in MovimientoMapper.mapEntityToDto: entity {}", entity );

        dto.setX(entity.getMoviX());
        dto.setY(entity.getMoviY());
        dto.setZ(entity.getMoviZ());
        dto.setDate(BaseMapper.formatDateToString(entity.getMoviFecha()));

        if (Objects.nonNull(entity.getMoviFKTelefono())){
            dto.setTelefono(TelefonoMapper.mapEntityToDto(entity.getMoviFKTelefono()));
        }

        _logger.debug( "Leaving MovimientoMapper.mapEntityToDto: dto {}", dto );

        return dto;
    }

}