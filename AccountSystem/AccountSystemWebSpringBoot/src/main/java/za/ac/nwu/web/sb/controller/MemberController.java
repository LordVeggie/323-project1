package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateMemberFlow;
import za.ac.nwu.logic.flow.FetchMemberFlow;


import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow,
                                 @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow){
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll()
    {
        List<MemberDto> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Member.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam( value = "Request body to create a new Member.", required = true)
            @RequestBody MemberDto member){
        MemberDto memberResponse = createMemberFlow.create(member);

        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    @ApiOperation(value = "Fetches the specified Member.", notes = "Fetch the Member corresponding to the given email.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getMember(
            @ApiParam(value = "The email that uniquely identifies the Member",
                    example = "s.storm4321@gmail.com",
                    name = "email",
                    required = true)
            @PathVariable("email") final String email){
        MemberDto member = fetchMemberFlow.getMemberByeEmail(email);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

