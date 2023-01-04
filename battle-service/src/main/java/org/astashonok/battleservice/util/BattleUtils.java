package org.astashonok.battleservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.astashonok.battleservice.constant.BattleConstants;
import org.astashonok.battleservice.entity.Battle;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BattleUtils {

	public static void updateByLastMove(@NonNull Battle battle, @NonNull UUID userId, int xCoordinate, int yCoordinate) {
		battle.getBoard()[yCoordinate][xCoordinate] = getParticipantMoveValue(battle, userId);
		battle.getLastMoveInfo().setParticipantId(userId);
		battle.getLastMoveInfo().setXCoordinate(xCoordinate);
		battle.getLastMoveInfo().setYCoordinate(yCoordinate);
		battle.setAvailableMoveQuantity(battle.getAvailableMoveQuantity() - 1);
	}

	public static int getParticipantMoveValue(@NonNull Battle battle, @NonNull UUID userId) {
		return battle.getXParticipantId().equals(userId)
				? BattleConstants.X_FIELD_VALUE
				: BattleConstants.O_FIELD_VALUE;
	}
}
