package com.sww.message.service.impl;

import com.sww.message.entity.Template;
import com.sww.message.mapper.TemplateMapper;
import com.sww.message.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;


    @Override
    public void add(Template template) {

    }
}
