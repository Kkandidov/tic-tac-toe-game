package org.astashonok.battleservice.component.calculator;

import lombok.NonNull;
import org.astashonok.battleservice.entity.Battle;

public interface BattleStateCalculator {

	void reCalculateBattleState(@NonNull Battle battle);
}