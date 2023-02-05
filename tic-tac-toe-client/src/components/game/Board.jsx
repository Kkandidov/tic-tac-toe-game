import {useState} from "react";
import Cell from "./Cell";
import s from './Board.module.css'

const Board = () => {

	const [board, setBoard] = useState(Array(196).fill(null))

	return (
			<div className={s.board}>
				{
					board.map((value, idx) => {
						return <Cell/>;
					})
				}
			</div>
	);
}

export default Board;