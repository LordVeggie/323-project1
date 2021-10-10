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

import za.ac.nwu.domain.dto.MemberBalanceDto;
import za.ac.nwu.domain.persistence.MemberBalance;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateMemberBalanceFlow;
import za.ac.nwu.logic.flow.FetchMemberBalanceFlow;

import java.util.List;

@RestController
@RequestMapping("member-balance")
public class MemberBalanceController {
}
