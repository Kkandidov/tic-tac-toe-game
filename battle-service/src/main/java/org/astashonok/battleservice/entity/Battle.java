package org.astashonok.battleservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.astashonok.battleservice.model.BattleState;
import org.astashonok.battleservice.model.LastMoveInfo;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Battle {

	private UUID id;
	private int dimension;
	private int[][] board;
	private int winningCountInRow;
	@NonNull
	private BattleState battleState;
	@NonNull
	private LastMoveInfo lastMoveInfo;
	private UUID xParticipantId;
	private UUID oParticipantId;
	private int availableMoveQuantity;
}
