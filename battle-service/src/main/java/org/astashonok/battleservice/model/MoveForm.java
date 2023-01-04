package org.astashonok.battleservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.astashonok.battleservice.constant.ErrorMessagePatterns;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class MoveForm {

	@NotNull(message = ErrorMessagePatterns.BATTLE_ID_IS_NULL)
	private final UUID battleId;

	@PositiveOrZero(message = ErrorMessagePatterns.X_COORDINATE_NOT_POSITIVE)
	private final int xCoordinate;

	@PositiveOrZero(message = ErrorMessagePatterns.Y_COORDINATE_NOT_POSITIVE)
	private final int yCoordinate;
}
