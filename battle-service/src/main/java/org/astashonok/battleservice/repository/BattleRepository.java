package org.astashonok.battleservice.repository;

import org.astashonok.battleservice.entity.Battle;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface BattleRepository {

	Battle findById(@NonNull UUID battleId);

	void save(Battle battle);
}
