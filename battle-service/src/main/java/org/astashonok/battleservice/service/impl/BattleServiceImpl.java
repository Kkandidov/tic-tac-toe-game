package org.astashonok.battleservice.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.astashonok.battleservice.component.calculator.BattleStateCalculator;
import org.astashonok.battleservice.entity.Battle;
import org.astashonok.battleservice.model.BattleState;
import org.astashonok.battleservice.model.MoveForm;
import org.astashonok.battleservice.repository.BattleRepository;
import org.astashonok.battleservice.service.BattleService;
import org.astashonok.battleservice.util.BattleUtils;
import org.astashonok.battleservice.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BattleServiceImpl implements BattleService {

	private final BattleRepository battleRepository;
	private final BattleStateCalculator battleStateCalculator;

	@Override
	public BattleState makeMove(@NonNull MoveForm moveForm) {
		Battle battle = Objects.requireNonNull(battleRepository.findById(moveForm.getBattleId()));
		return makeMove(battle, moveForm);
	}

	private BattleState makeMove(Battle battle, MoveForm moveForm) {
		BattleUtils.updateByLastMove(battle, SecurityUtils.getCurrentUserId(), moveForm.getXCoordinate(), moveForm.getYCoordinate());

		battleStateCalculator.reCalculateBattleState(battle);
		battleRepository.save(battle);

		return battle.getBattleState();
	}
}
