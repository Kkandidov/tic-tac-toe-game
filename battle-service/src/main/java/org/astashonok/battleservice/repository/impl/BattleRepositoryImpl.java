package org.astashonok.battleservice.repository.impl;

import org.astashonok.battleservice.entity.Battle;
import org.astashonok.battleservice.repository.BattleRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BattleRepositoryImpl implements BattleRepository {

	@Override
	public Battle findById(UUID battleId) {
		return null;
	}

	@Override
	public void save(Battle battle) {

	}
}
