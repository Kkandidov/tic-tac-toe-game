package org.astashonok.battleservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LastMoveInfo {

	private UUID participantId;
	private int xCoordinate;
	private int yCoordinate;
}
