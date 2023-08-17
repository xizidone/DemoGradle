package tech.tongyu.bct.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;
import ma.glasnost.orika.metadata.Type;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * bean对象之间copy
 *
 */
public class BeanCopyUtils {

    /**
     * 跳过null
     */
    private static final MapperFacade MAPPER_FACADE;


    /**
     * 不跳过null
     */
    private static final MapperFacade MAPPER_FACADE1;

    static {
        DefaultMapperFactory factory = new Builder().mapNulls(false).build();
        factory.getConverterFactory().registerConverter(new InstantConverter());
        MAPPER_FACADE = factory.getMapperFacade();


        DefaultMapperFactory factory2 = new DefaultMapperFactory.Builder().build();
        factory2.getConverterFactory().registerConverter(new InstantConverter());
        MAPPER_FACADE1 = factory2.getMapperFacade();
    }

    public static <T> T copy(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        return MAPPER_FACADE1.map(source, target);
    }

    public static <T> void copy(Object source, Object target) {
        MAPPER_FACADE1.map(source, target);
    }

    public static <T> void copyExNull(Object source, Object target) {
        MAPPER_FACADE.map(source, target);
    }


    public static <T> List<T> copyCollection(List<?> objs, Class<T> clazz) {
        if (objs == null) {
            return null;
        }
        List<T> list = new ArrayList<>(objs.size());
        for (Object obj : objs) {
            if (obj == null) {
                continue;
            }
            list.add(copy(obj, clazz));
        }
        return list;
    }


}

/**
 * instant LocalDateTime转换器
 */
class InstantConverter extends BidirectionalConverter<Instant, LocalDateTime> {

    @Override
    public LocalDateTime convertTo(Instant source, Type<LocalDateTime> destinationType, MappingContext mappingContext) {
        return LocalDateTime.ofInstant(source, ZoneId.systemDefault());
    }

    @Override
    public Instant convertFrom(LocalDateTime source, Type<Instant> destinationType, MappingContext mappingContext) {
        return source.atZone(ZoneId.systemDefault()).toInstant();
    }
}
