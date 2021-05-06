package ru.kpfu.itis.kutyavina.styleweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class StringConverter implements GenericConverter {
    private final Class<?> classs;

    @Autowired
    private EntityManager em;

    public StringConverter(Class<?> classs) {
        super();
        this.classs = classs;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> types = new HashSet<ConvertiblePair>();
        types.add(new ConvertiblePair(String.class, this.classs));
        types.add(new ConvertiblePair(this.classs, String.class));
        return types;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (sourceType.getType().equals(String.class)) {
            if ((source).equals("....")) return null;

            Long id = Long.parseLong((String) source);
            return this.em.find(this.classs, id);

        } else if (this.classs.equals(sourceType.getType())) {
            if (source == null) {
                return "";
            }
        }
        throw new IllegalArgumentException("Cannot convert, sorry :( ");
    }
}
