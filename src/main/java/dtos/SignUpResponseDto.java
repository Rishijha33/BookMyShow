package dtos;

import lombok.Getter;
import lombok.Setter;
import models.ResponseStatus;

@Getter
@Setter
public class SignUpResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
