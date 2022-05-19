package org.sdo.controller;

import org.sdo.entity.Theory;
import org.sdo.service.Service;
import org.sdo.service.TheoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/theory")
public class TheoryController extends AbstractController<Theory> {
    @Autowired
    private TheoryService service;

    @Override
    public TheoryService getService() {
        return service;
    }
}
