package com.project.betwin.exception.UserException;

import com.project.betwin.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class UserNotFoundDetails extends ExceptionDetails {
}
