package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.exceptions.GameException;
import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.Player;
import com.iba.demo.tictactoe.model.PlayerMark;
import com.iba.demo.tictactoe.model.Turn;
import com.iba.demo.tictactoe.service.TurnTakingService;

public class TurnTakingServiceImpl implements TurnTakingService {
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictactoe.service.impl.TurnTakingService#takeTurn(com.iba.demo.tictactoe.model.Game, com.iba.demo.tictactoe.model.Turn)
	 */
	@Override
	public void takeTurn(Game game, Turn turn) throws GameException {
		final BoardCell turnCell = turn.getCell();
		final Player turnTaker = turn.getTaker();
		updateBoardCell(game, turnCell);
		updateTurnTaker(game, turnTaker);
		updateRemainingTurns(game);
	}

	private void updateRemainingTurns(Game game) {
		int remainingTurns = game.getRemainingTurns();
		remainingTurns --;
		game.setRemainingTurns(remainingTurns);
	}

	private void updateBoardCell(Game game, BoardCell cell) {
		Board board = game.getBoard();
		board.putCell(cell);
	}
	
	private void updateTurnTaker(Game game, Player turnTaker) throws GameException {
		Player nextTurnPlayer = resolveNextTurnTaker(game, turnTaker);
		game.setTurnTaker(nextTurnPlayer);
	}

	private Player resolveNextTurnTaker(Game game, Player turnTaker) throws GameException {
		if (PlayerMark.CROSS.equals( turnTaker.getMark() ) ) {
			return game.getNoughtPlayer();
		} 
		return game.getCrossPlayer();		
	}

}
