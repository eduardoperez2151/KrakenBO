package com.geocom.services.implementation;

import com.geocom.dtos.LocalDTO;
import com.geocom.models.Local;
import com.geocom.repositories.LocalRepository;
import com.geocom.services.LocalService;
import com.geocom.services.abstracts.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class LocalServiceImpl extends AbstractService<LocalDTO,Local,Long> implements LocalService {

    @Autowired
    public LocalServiceImpl(final LocalRepository repository, final ConversionService conversionService) {
        super(repository, conversionService, LocalDTO.class, Local.class);
    }
}
