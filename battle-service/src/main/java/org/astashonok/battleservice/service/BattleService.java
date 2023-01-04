package org.astashonok.battleservice.service;

import lombok.NonNull;
import org.astashonok.battleservice.model.BattleState;
import org.astashonok.battleservice.model.MoveForm;

public interface BattleService {

	BattleState makeMove(@NonNull MoveForm moveForm);
}
