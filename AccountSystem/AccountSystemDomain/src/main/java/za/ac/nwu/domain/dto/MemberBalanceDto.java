package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.MemberBalance;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "MemberBalance", description = "A DTO that represents the MemberBalance")
public class MemberBalanceDto  implements Serializable
{
}
