package org.astashonok.battleservice.component.calculator.impl;

import lombok.NonNull;
import org.astashonok.battleservice.component.calculator.BattleStateCalculator;
import org.astashonok.battleservice.entity.Battle;
import org.astashonok.battleservice.model.BattleState;
import org.astashonok.battleservice.model.BattleStatus;
import org.astashonok.battleservice.model.LastMoveInfo;
import org.astashonok.battleservice.util.BattleUtils;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class BattleStateCalculatorImpl implements BattleStateCalculator {

	@Override
	public void reCalculateBattleState(@NonNull Battle battle) {
		BattleState battleState = battle.getBattleState();

		int[][] board = battle.getBoard();
		LastMoveInfo moveInfo = battle.getLastMoveInfo();
		UUID participantId = moveInfo.getParticipantId();
		int x = moveInfo.getXCoordinate();
		int y = moveInfo.getYCoordinate();
		int countInRow = battle.getWinningCountInRow();
		int fieldValue = BattleUtils.getParticipantMoveValue(battle, participantId);

		boolean isParticipantWinner = isWinningRow(board, x, y, countInRow, fieldValue)
				|| isWinningColumn(board, x, y, countInRow, fieldValue)
				|| isWinningFirstDiagonal(board, x, y, countInRow, fieldValue)
				|| isWinningSecondDiagonal(board, x, y, countInRow, fieldValue);

		if (isParticipantWinner) {
			battleState.setWinnerId(participantId);
			battleState.setStatus(BattleStatus.COMPLETED);
		} else if (battle.getAvailableMoveQuantity() == 0) {
			battleState.setStatus(BattleStatus.DRAW);
		}
	}
	private static boolean isWinningFirstDiagonal(int[][] board, int x, int y, int countInRow, int fieldValue) {
		Tuple2<Integer, Integer> xAndY = getStartXAndYCoordinates(x, y, countInRow);
		int endXIndex = Math.min(x + countInRow, board.length);
		int endYIndex = Math.min(y + countInRow, board.length);

		int resultCountInRow = 0;
		int currentCountInRow = 0;
		int currentX = xAndY.v1;
		int currentY = xAndY.v2;
		while (currentX < endXIndex && currentY < endYIndex) {
			if (board[currentY][currentX] == fieldValue) {
				currentCountInRow++;
			} else {
				resultCountInRow = Math.max(resultCountInRow, currentCountInRow);
				currentCountInRow = 0;
			}
			currentX++;
			currentY++;
		}

		return Math.max(resultCountInRow, currentCountInRow) >= countInRow;
	}

	private static boolean isWinningSecondDiagonal(int[][] board, int x, int y, int countInRow, int fieldValue) {
		Tuple2<Integer, Integer> xAndY = getStartXAndYCoordinates(board, x, y, countInRow);
		int endXIndex = Math.min(x + countInRow, board.length);

		int resultCountInRow = 0;
		int currentCountInRow = 0;
		int currentX = xAndY.v1;
		int currentY = xAndY.v2;
		while (currentX < endXIndex && currentY >= 0) {
			if (board[currentY][currentX] == fieldValue) {
				currentCountInRow++;
			} else {
				resultCountInRow = Math.max(resultCountInRow, currentCountInRow);
				currentCountInRow = 0;
			}
			currentX++;
			currentY--;
		}

		return Math.max(resultCountInRow, currentCountInRow) >= countInRow;
	}

	private static Tuple2<Integer, Integer> getStartXAndYCoordinates(int x, int y, int countInRow) {
		int difference = x - y;

		int currentX = Math.max(x - countInRow + 1, 0);
		while (currentX - difference < 0) {
			currentX++;
		}

		return Tuple.tuple(currentX, currentX - difference);
	}

	private static Tuple2<Integer, Integer> getStartXAndYCoordinates(int[][] board, int x, int y, int countInRow) {
		int summa = x + y;
		int endYIndex = Math.min(y + countInRow, board.length);

		int currentX = Math.max(x - countInRow + 1, 0);
		while (currentX + endYIndex < summa) {
			currentX++;
		}

		return Tuple.tuple(currentX, summa - currentX);
	}

	private static boolean isWinningRow(int[][] board, int x, int y, int countInRow, int fieldValue) {
		return isWinningCombination(board, x, countInRow, index -> board[y][index] == fieldValue);
	}

	private static boolean isWinningColumn(int[][] gameBoard, int x, int y, int countInRow, int fieldValue) {
		return isWinningCombination(gameBoard, y, countInRow, index -> gameBoard[index][x] == fieldValue);
	}

	private static boolean isWinningCombination(int[][] board, int checkedPosition, int countInRow,
												Function<Integer, Boolean> fieldTest) {

		int startIndex = Math.max(checkedPosition - countInRow + 1, 0);
		int endIndex = Math.min(checkedPosition + countInRow, board.length);

		int resultCountInRow = 0;
		int currentCountInRow = 0;
		for (int i = startIndex; i < endIndex; i++) {
			if (fieldTest.apply(i)) {
				currentCountInRow++;
			} else {
				resultCountInRow = Math.max(resultCountInRow, currentCountInRow);
				currentCountInRow = 0;
			}
		}

		return Math.max(resultCountInRow, currentCountInRow) >= countInRow;
	}
}