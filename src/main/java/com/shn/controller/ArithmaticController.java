package com.shn.controller;

import com.shn.exceptions.ArithmaticCustomException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArithmaticController {

    @ApiResponses({
            @ApiResponse(code = 200, message = "ok da"),
            @ApiResponse(code = 404, message = "Not found da"),
            @ApiResponse(code = 500, message = "Internal server error da")
    })
    @GetMapping("/divideNos")
    public Integer divideNos(@RequestParam Integer no1, @RequestParam Integer no2) {
        try {
            return no1 / no2;
        } catch (Exception e) {
            throw new ArithmaticCustomException("Wrong inputs");
        }
    }
}
