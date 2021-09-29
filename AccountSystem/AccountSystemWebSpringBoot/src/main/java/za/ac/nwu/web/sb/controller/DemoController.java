package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.nwu.domain.service.GeneralResponse;
//import za.ac.nwu.domain.service.Pong;

@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping("/ping")
    @ApiOperation(value = "Echo the Ping.", notes = "This Echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<String>> ping(
            @RequestParam(value = "echo", defaultValue = "pong")
            String echo)
    {
        GeneralResponse<String> response = new GeneralResponse<>(true, echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    @ApiOperation(value = "Echo the Ping.", notes = "This Echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<String>> getPing(
            @RequestParam(value = "echo", defaultValue = "pong", required = false)
                    String echo)
    {
        GeneralResponse<String> response = new GeneralResponse<>(true, echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Missing the pong class was never shown, so I removed it
    //@PostMapping("/ping")
    //@ApiOperation(value = "Create new pong.", notes = "Creates a new pong in the system.")
    //@ApiResponses(value = {
    //        @ApiResponse(code = 201, message = "The Pong was created successfully", response = GeneralResponse.class),
    //        @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
    //        @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
    //        @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    //})
//
    //public ResponseEntity<GeneralResponse<String>> postPong(
    //        @RequestParam(value = "Request body to create a new pong", required = true)
    //        @RequestBody Pong pong)
    //{
    //    GeneralResponse<Pong> response = new GeneralResponse<>(true, pong);
    //    return new ResponseEntity<>(response, HttpStatus.CREATED);
    //}

    @PostMapping("/error")
    @ApiOperation(value = "Throws an exception")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<String>> ping(){
        throw new RuntimeException("Give an error");
    }

   // public GeneralResponse<String> ping(@RequestParam(value = "echo", defaultValue = "pong") String echo){
      //  return new GeneralResponse<String>(true, echo);
   // }
}
