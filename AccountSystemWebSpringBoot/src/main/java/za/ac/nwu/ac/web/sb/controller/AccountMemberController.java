package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("account-system")
public class AccountMemberController {

    private final CreateMemberFlow createMemberFlow;
    private final FetchMemberFlow fetchMemberFlow;

    @Autowired
    public AccountMemberController(FetchMemberFlow fetchMemberFlow, @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the config Account Members", notes = "Returns a list of Members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account member returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountMemberDto>>> getAll() {
        List<AccountMemberDto> accountMembers = fetchMemberFlow.getAllAccountMembers();
        GeneralResponse<List<AccountMemberDto>> response = new GeneralResponse<>(true, accountMembers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates Account Members", notes = "Creates new Account Members in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account member created succesufully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountMemberDto>> create(
            @ApiParam(value = "Request body to create a new AccountMember", required = true)
            @RequestBody AccountMemberDto accountMember) {
        AccountMemberDto accountMemberResponse = createMemberFlow.create(accountMember);
        GeneralResponse<AccountMemberDto> response = new GeneralResponse<>(true, accountMemberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}




