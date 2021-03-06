package com.pxjoke.controllers;

import com.pxjoke.entities.OrderPositionEntity;
import com.pxjoke.services.OrderPositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderPositions")
public class OderPositionsController extends AbstractController<OrderPositionEntity>{

    @Autowired
    OrderPositionsService orderPositionsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable Long id){
        return run(() -> orderPositionsService.delete(id));
    }


}
